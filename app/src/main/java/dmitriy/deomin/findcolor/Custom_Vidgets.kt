package dmitriy.deomin.findcolor

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button

class Btn : Button {
    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    override fun setOnClickListener(l: View.OnClickListener?) {
        val wrapper = View.OnClickListener {
            startAnimation(
                AnimationUtils.loadAnimation(
                    this.context,
                    dmitriy.deomin.findcolor.R.anim.alfa
                )
            )
            l?.onClick(it)
        }
        super.setOnClickListener(wrapper)
    }

    fun init() {

//        this.typeface = Main.face
//        this.gravity = Gravity.CENTER
    }
}