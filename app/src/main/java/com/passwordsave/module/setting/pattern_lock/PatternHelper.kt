package com.passwordsave.module.setting.pattern_lock

import android.text.TextUtils
import android.util.Log
import com.passwordsave.module.setting.pattern_lock.SecurityUtil.encrypt
import com.tencent.mmkv.MMKV

/**
 * Created by quan on 14/10/2017.
 */
open class PatternHelper {
    var message: String? = null
        private set
    private var storagePwd: String? = null
    private var tmpPwd: String? = null
    private var times = 0
    var isFinish = false
        private set
    var isOk = false
        private set
    var isSuccess = false
        private set
    fun validateForSetting(hitIndexList: List<Int>?) {
        isFinish = false
        isOk = false
        if (hitIndexList == null || hitIndexList.size < MAX_SIZE) {
            tmpPwd = null
            message = sizeErrorMsg
            return
        }
        //1. draw first time
        if (TextUtils.isEmpty(tmpPwd)) {
            tmpPwd = convert2String(hitIndexList)
            message = reDrawMsg
            isOk = true
            return
        }
        //2. draw second times
        if (tmpPwd == convert2String(hitIndexList)) {
            message = settingSuccessMsg
            saveToStorage(tmpPwd)
            isOk = true
            isFinish = true
        } else {
            tmpPwd = null
            message = diffPreErrorMsg
        }
    }

    fun validateForChecking(hitIndexList: List<Int>?) {
        isOk = false
        if (hitIndexList == null || hitIndexList.size < MAX_SIZE) {
            times++
            Log.e("times++",times.toString())

            isFinish = times >= MAX_TIMES
            message = pwdErrorMsg
            return
        }
        storagePwd = fromStorage
        if (!TextUtils.isEmpty(storagePwd) && storagePwd == convert2String(hitIndexList)) {
            message = checkingSuccessMsg
            isOk = true
            isFinish = true
            isSuccess = true
        } else {
            times++
            Log.e("times++++",times.toString())
            isFinish = times >= MAX_TIMES
            message = pwdErrorMsg
        }
    }

    private val remainTimes: Int
        get() = if (times < 5) MAX_TIMES - times else 0
    private val reDrawMsg: String = "???????????????????????????"
    private val settingSuccessMsg: String = "?????????????????????????????????"
    private val checkingSuccessMsg: String = "???????????????"
    private val sizeErrorMsg: String = String.format("???????????????%d?????????????????????", MAX_SIZE)
    private val diffPreErrorMsg: String = "??????????????????????????????????????????"
    private val pwdErrorMsg: String
        get() = String.format("?????????????????????%d?????????", remainTimes)

    private fun convert2String(hitIndexList: List<Int>): String {
        return hitIndexList.toString()
    }

    private fun saveToStorage(gesturePwd: String?) {
        val encryptPwd = encrypt(gesturePwd!!)
        MMKV.mmkvWithID("gesture").putString(GESTURE_PWD_KEY,encryptPwd)
    }

    private val fromStorage: String? = MMKV.mmkvWithID("gesture").getString(GESTURE_PWD_KEY,"")?.let { SecurityUtil.decrypt(it) }


    companion object {
        const val MAX_SIZE = 4
        const val MAX_TIMES = 5
        private const val GESTURE_PWD_KEY = "gesture_pwd_key"
    }
}