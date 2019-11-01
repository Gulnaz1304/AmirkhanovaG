package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = listOf(
                ZodiacSign("aquarius", drawableByName("aquarius"), "born are shy and quiet but highly intellectual people. They are dreamy and modest. They like freedom, have original ideas, some of which are crazy!"
                        , "January 20 - February 18"),
                ZodiacSign("aries", drawableByName("aries"), "are purposeful and rude. You like jokes, parties and loud music. You are good at sport and don’t ask for advice. Sometimes you are a bit selfish.",
                        "March 21 - April 20"),
                ZodiacSign("cancer", drawableByName("cancer"), "are emotional and loving, intuitive and imaginative, shrewd and cautious. But sometimes they are changeable and moody, overemotional and touchy, clinging and unable to let go.",
                        "June 22 - July 22"),
                ZodiacSign("capricorn", drawableByName("capricorn"), "likes to do things slowly and thoroughly. They are hardworking and cool-headed. Capricorn is quiet and serious and also works hard. Their friends like them because they never do stupid things.",
                        "December 22 - January 19"),
                ZodiacSign("gemini", drawableByName("gemini"), "born love to talk. They love surprises. They like chatting with your friends, while doing a lot of things at once.",
                        "May 21 - June 21"),
                ZodiacSign("leo", drawableByName("leo"), "are vain and ambitious. They are inborn leaders, who want to be rich and important one day. Leos are dramatic and dominant. They are generous and warmhearted, faithful and loving. Sometimes they are bossy and interfering.", "July 23 - August 22"),
                ZodiacSign("libra", drawableByName("libra"), "a good listener. They are affectionate and appreciate freedom. People like you because you always say nice things and hate fights. You want everyone to be happy. You’re a bit lazy.",
                        "September 23 - October 22"),
                ZodiacSign("pisces", drawableByName("pisces"), "are faithful and caring. They are charming and have good sense of humor. They are friendly and kind and good at art and they love music. They often lose things and forget about time.",
                        "February 19 - March 20"),
                ZodiacSign("sagittarius", drawableByName("sagittarius"), "is curious and energetic. It is a leader but a kind leader. They are friendly and spend money like water. They always tell the truth? Even if this can hurt their friend’s feelings.",
                        "November 22 - December 21"),
                ZodiacSign("scorpio", drawableByName("scorpio"), "is determinate and obstinate. They are very strong persons and always get what you want. They are very good friends. Scorpios are believed to be ruled by their desires",
                        "October 23 - November 21"),
                ZodiacSign("taurus", drawableByName("taurus"), "People born under the Taurus sign are powerful and reliable. They work hard, very practical and helpful. They don’t like changes, but not delicious food!",
                        "April 21 - May 20"),
                ZodiacSign("virgo", drawableByName("virgo"), "ntelligence and concealment — these are two your main personal qualities. Virgos are good investigators and researchers. They always work hard and choose friends carefully, because they must be perfect!"
                        , "August 23 - September 22")


        )
        rv_zodiac_signs.adapter = ZodiacSignAdapter(items)
        rv_zodiac_signs.layoutManager = LinearLayoutManager(this)


    }

    class ZodiacSignAdapter(private val listOfZodiacSigns: List<ZodiacSign>) : RecyclerView.Adapter<ZodiacSignAdapter.ZodiacSignHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ZodiacSignHolder {
            val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.list_item, parent, false)
            return ZodiacSignHolder(itemView)

        }

        override fun getItemCount(): Int {
            return listOfZodiacSigns.size
        }

        override fun onBindViewHolder(holder: ZodiacSignHolder, position: Int) {
            holder?.nametextView?.text = listOfZodiacSigns[position].name
            holder?.datetextView?.text = listOfZodiacSigns[position].dates
            holder?.imageView?.setImageResource(listOfZodiacSigns[position].resourceId)
            holder.itemView.setOnClickListener { v ->
                val intent = Intent(v.context, DetailedInformationActivity::class.java)
                intent.putExtra("name", listOfZodiacSigns[position].name)
                intent.putExtra("date", listOfZodiacSigns[position].dates)
                intent.putExtra("image", listOfZodiacSigns[position].resourceId)
                intent.putExtra("description", listOfZodiacSigns[position].description)
                v?.context?.startActivity(intent)
            }
        }


        class ZodiacSignHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
            var nametextView: TextView?
            var imageView: ImageView?
            var datetextView: TextView?

            init {
                nametextView = itemView?.findViewById(R.id.textView4)
                datetextView = itemView?.findViewById(R.id.textView6)
                imageView = itemView?.findViewById(R.id.image)
            }
        }

    }

    private fun drawableByName(name: String) = resources.getIdentifier(name, "drawable", packageName)

}
