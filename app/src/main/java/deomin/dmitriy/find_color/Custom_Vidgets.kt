package deomin.dmitriy.find_color

import android.app.AlertDialog
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import deomin.dmitriy.find_color.`fun`.rnd_color
import deomin.dmitriy.find_color.`fun`.vibrator

class Btn : Button {
    constructor(context: Context) : super(context) { init() }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) { init() }
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) { init() }

    var background_color = rnd_color()

//    override fun setOnClickListener(l: View.OnClickListener?) {
//        val wrapper = View.OnClickListener {
//            clik_anim()
//            vibrator(this.context)
//            l?.onClick(it)
//        }
//        super.setOnClickListener(wrapper)
//    }

    fun init() {
        this.textSize = 16F
        this.setBackgroundColor(background_color)
    }

    fun setBackcolor(color:Int){
        background_color = color
        init()
    }

    fun clik_anim(){
        vibrator(context,10L)
        startAnimation(
            AnimationUtils.loadAnimation(
                this.context,
                //dmitriy.deomin.findcolor.R.anim.alfa
                deomin.dmitriy.find_color.R.anim.alfa
            )
        )
    }

    fun start_anim_error(){
        startAnimation(
            AnimationUtils.loadAnimation(
                this.context,
                deomin.dmitriy.find_color.R.anim.shake_error
            )
        )
    }

    fun start_anim_help(){
        startAnimation(
            AnimationUtils.loadAnimation(
                this.context,
                deomin.dmitriy.find_color.R.anim.shake_help
            )
        )
    }


}


class DialogWindow(context: Context, loaut: Int,onTop: Boolean = false) {

    var full_skren = false

    private val alertDialog: AlertDialog
    private val content: View
    private var event: (() -> Unit)? = null

    init {
        val builder = AlertDialog.Builder(context)
        content = LayoutInflater.from(context).inflate(loaut, null)
        builder.setView(content)

        this.alertDialog = builder.create()

        if(onTop){
            alertDialog.setCanceledOnTouchOutside(false)
        }else{
            alertDialog.setCanceledOnTouchOutside(true)
        }

        //сместим немногов низ окно
        val params = this.alertDialog.window?.attributes

        //https://it-giki.com/post/355.html
        params!!.y = 150

        //применяем правки
        this.alertDialog.window!!.attributes = params

        this.alertDialog.setOnCancelListener { onclose() }

        //показываем окно
        this.alertDialog.show()
    }

    fun view(): View {
        return content
    }

    fun close() {
        alertDialog.cancel()
    }

    //срабатывает при закрытии окна
    private fun onclose(){
        event?.invoke()
    }

    //выполняется на стороне
    fun onClose(block: () -> Unit) {
        event = block
    }


    fun full_screen(){
        full_skren = if(full_skren){
            alertDialog.window!!.setLayout(WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT)
            false
        }else{
            alertDialog.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT)
            true
        }
    }
}


class Text : TextView {
    constructor(context: Context) : super(context) {init()}
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {init()}
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr){init()}

    fun init(){
//        this.typeface = Main.face
//        this.setTextColor(Main.COLOR_TEXT)
    }
}