package com.passwordsave.module.collect

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.text.InputType
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.passwordsave.R
import com.passwordsave.base.BaseFragment
import com.passwordsave.module.net_account.AddAccountActivity
import com.passwordsave.module.local_account.Account2
import com.passwordsave.utils.showToast
import com.socks.library.KLog
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_account.*
import kotlinx.android.synthetic.main.item_account.view.*
import kotlinx.android.synthetic.main.layout_top.*
import java.util.ArrayList

class CollectFragment : BaseFragment() {
    private val mAdapter = AccountAdapter(arrayListOf())
    private val dataList: ArrayList<Account2> =
        ArrayList()

    override fun getLayoutId(): Int {
        return R.layout.fragment_collect
    }

    override fun initView() {
        top_title.text = "我的收藏"
        rv_account.layoutManager = LinearLayoutManager(requireContext())
        rv_account.adapter = mAdapter
        onRefresh()
    }

    override fun lazyLoad() {
    }

    override fun initListener() {
        smartLayout.setOnRefreshListener { onRefresh() }
        smartLayout.setEnableLoadMore(false)
        fab.setOnClickListener {
            startActivity(Intent(requireContext(), AddAccountActivity::class.java))
        }

        et_search.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                //如果actionId是搜索的id，则进行下一步的操作
                getList()
                return@setOnEditorActionListener true
            }
            false
        }
    }

    private fun onRefresh() {
        dataList.clear()
        getList()
    }

    @SuppressLint("CheckResult")
    private fun getList() {
        mAppDatabase.accountDao()!!
            .loadAccountByCollect(true,"%"+et_search.text.toString()+"%")//模糊搜索
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { t ->
                onRefreshComplete()
                if (t != null) {
                    KLog.e("t",t.size)
                    mAdapter.setNewData(t)
                }
            }
    }

    private fun onRefreshComplete() { //刷新或加载更多完成
        smartLayout.finishRefresh()
        smartLayout.finishLoadMore()
    }

    inner class AccountAdapter(data: MutableList<Account2>) :
        BaseQuickAdapter<Account2, BaseViewHolder>(
            R.layout.item_account,
            data
        ) {
        @SuppressLint("SetTextI18n")
        override fun convert(helper: BaseViewHolder, item: Account2) {
            val itemView = helper.itemView
            itemView.item_title.text = item.title
            itemView.item_account.text = item.account
            itemView.item_pwd.text = item.password
            if(item.isShow){
                itemView.iv_eye.setImageResource(R.drawable.ic_eye_2)
            }else{
                itemView.iv_eye.setImageResource(R.drawable.ic_eye_1)
            }
            itemView.iv_eye.setOnClickListener {
                if(item.isShow){
                    itemView.iv_eye.setImageResource(R.drawable.ic_eye_1)
                    itemView.item_pwd.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                }else{
                    itemView.iv_eye.setImageResource(R.drawable.ic_eye_2)
                    itemView.item_pwd.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_NORMAL
                }
                item.isShow = !item.isShow
            }

            itemView.iv_copy.setOnClickListener {
                copyText(itemView.item_account)
            }

            itemView.iv_copy2.setOnClickListener {
                copyText(itemView.item_pwd)
            }
            itemView.delete_layout.setOnClickListener {
                val data = Account2()
                data.id = item.id
                mAppDatabase.accountDao()!!.deleteAccount(data)
            }
            itemView.cl_item.setOnClickListener {

            }
        }
    }

    fun copyText(tv : TextView){
        val manager =requireContext().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText("text", tv.text)
        manager.setPrimaryClip(clipData)
        showToast("文本已复制")
    }
}