package com.passwordsave.module.main

import android.annotation.SuppressLint
import android.view.View
import com.passwordsave.R
import com.passwordsave.base.BaseActivity
import kotlinx.android.synthetic.main.activity_term.*
import kotlinx.android.synthetic.main.layout_top.*

class Term2Activity : BaseActivity(){
    override fun layoutId(): Int {
        return R.layout.activity_term
    }

    override fun initData() {
        top_title.text = "隐私政策"
        iv_back.visibility = View.VISIBLE

    }

    @SuppressLint("SetTextI18n")
    override fun initView() {
        tv_term_content.text="引言\n" +
                "账号管家由文伟权进行开发并负责维护运营，账号管家（“我们”）深知个人信息对您的重要性，因此我们非常重视保护您的隐私和个人信息。我们同样将本政策中的内容以高度严谨的态度对待和处理。\n" +
                "您应当仔细阅读、充分理解本《隐私政策》后使用我们的产品/服务，如果您不同意本政策的内容，将可能导致我们的产品/服务无法正常运行，或者无法达到我们的产品/服务正常运行的服务效果，您应立即停止访问/使用我们使用我们的产品/服务。您使用或者继续使用我们提供的产品/服务的行为，都表示您充分理解和同意本《隐私政策》（包括更新版本）的全部内容。\n" +
                "我们将竭尽全力通过合理有效的信息安全技术与管理流程,防止您的信息泄露、损毁、丢失。\n" +
                "我们严格遵照法律法规，保护您的通信秘密，为您提供安全的通信服务。\n" +
                "为了向您和其他用户提供更好的服务，我们仅收集必要的信息。\n" +
                "本《隐私政策》主要向您说明：\n" +
                "我们收集的信息\n" +
                "我们根据合法、正当、必要的原则，仅收集实现产品功能所必要的信息。\n" +
                "\n" +
                "您在使用我们服务时主动提供的信息\n" +
                "\n" +
                "我们在您使用服务时获取的信息\n" +
                "\n" +
                "设备信息\n" +
                "\n" +
                "首次启动软件时,会收集设备型号、操作系统版本、屏幕尺寸等信息\n" +
                "\n" +
                "(1)允许获取网络权限\n" +
                "\n" +
                "获取网络权限，是为了本软件联网功能能正常使用。\n" +
                "\n" +
                "(2)允许获取网络状态权限\n" +
                "\n" +
                "网络连接情况是复杂多变的，我们需要随时监听、判断用户设备的网络情况，并及时的反馈给用户，也保证我们的产品能在不同的网络环境下平稳的运行，因此我们需要获取网络状态权限。\n" +
                "\n" +
                "(3)允许获取手机读写、存储权限\n" +
                "\n" +
                "为了把用户信息存在手机上，以及用户记录的账号数据我们也需要保存到服务端，以便下次用户需要时再从服务端同步到本地，并存储到设备的本地存储卡上，因此我们需要获取手机的读写、存储权限。\n" +
                "\n" +
                "(4)允许未知应用安装权限\n" +
                "\n" +
                "当我们的产品有更新需求时，我们会在产品内通过弹框的形式告知用户升级我们的产品，当用户选择升级时，我们需要系统允许安装我们的产品的权限。\n" +
                "\n" +
                "(5)允许获取摄像头权限\n" +
                "App中扫一扫功能需要使用摄像头进行扫描\n" +
                "\n" +
                "\n" +
                "我们不会将您的个人信息转让给任何公司、组织和个人，但以下情况除外：\n" +
                "  1、事先获得您明确的同意或授权；\n" +
                "  2、根据适用的法律法规、法律程序的要求、强制性的行政或司法要求所必须的情况进行提供；\n" +
                "  3、符合与您签署的相关协议（包括在线签署的电子协议以及相应的平台规则）或其他的法律文件约定所提供；\n" +
                "  4、为了保护国家安全、公共安全以及您和其他个人的重大合法权益而需要共享您的个人信息；\n" +
                "如果我们发生合并、收购或破产清算可能涉及到个人信息转让时，我们会要求新的持有您个人信息的公司、组织继续受本政策的约束,否则，我们将要求该公司、组织重新征求您的授权同意。.\n" +
                "我们分享的信息\n" +
                "\n" +
                "本软件收集的个人信息,目前不会以任何形式分享给第三方\n" +
                "\n" +
                "例如：未来业务的持续发展，当发生合并、收购、资产转让等交易导致向第三方分享您的个人信息时，我们将通过公告告知您相关情形，按照法律法规及不低于本政策所要求的标准继续保护或要求新的管理者继续保护您的个人信息。\n" +
                "\n" +
                "我们会将所收集到的信息用于大数据分析。\n" +
                "\n" +
                "例如：我们将收集到的信息用于分析形成不包含任何个人信息的热力图或洞察报告。 我们可能对外公开并与我们的合作伙伴分享经统计加工后不含身份识别内容的信息，用于了解用户如何使用我们服务或让公众了解我们服务的总体使用趋势。\n" +
                "\n" +
                "实现广告相关的共享信息\n" +
                "\n" +
                "广告显示\n" +
                "\n" +
                "我们可能与委托我们进行推广和广告投放的合作伙伴共享不识别您个人身份信息及去标识化的设备信息或匿名化后的信息，以帮助其在不识别您个人身份的前提下提升广告有效触达率。\n" +
                "\n" +
                "广告统计\n" +
                "\n" +
                "我们可能与业务的服务商、供应商和其他合作伙伴共享分析去标识化的设备信息或统计信息，这些信息无法与您的真实信息相关联，这些信息将帮助我们分析、衡量广告和相关服务的有效性。\n"
                
    }

    override fun initListener() {
        iv_back.setOnClickListener { finish() }
    }

    override fun start() {
    }
}