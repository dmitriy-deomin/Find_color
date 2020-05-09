package dmitriy.deomin.findcolor

import android.app.AlertDialog
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.Button

class Btn : Button {
    constructor(context: Context) : super(context) { init() }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) { init() }
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) { init() }

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


class Window(context: Context, loaut: Int,onTop: Boolean = false) {

    var full_skren = false

    private val alertDialog: AlertDialog
    private val content: View

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

        //показываем окно
        this.alertDialog.show()
    }

    fun view(): View {
        return content
    }

    fun close() {
        alertDialog.cancel()
    }

    fun full_screen(){
        full_skren = if(full_skren){
            alertDialog.window!!.setLayout(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT)
            false
        }else{
            alertDialog.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT)
            true
        }
    }
}