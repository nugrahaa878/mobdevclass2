// import menyesuaikan (tekan alt + space di bagian error / merah, terus tekan import)

class ListHeroAdapter(private val listHero: ArrayList<Hero>) : RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_hero, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listHero[position])
    }

    override fun getItemCount(): Int = listHero.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(hero: Hero) {
            with(itemView){
                Glide.with(itemView.context)
                    .load(hero.photo)
                    .apply(RequestOptions().override(55, 55))
                    .into(img_item_photo)
                tv_item_name.text = hero.name
                tv_item_description.text = hero.description

            }
        }
    }
}