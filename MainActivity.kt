// import menyesuaikan (tekan alt + space di bagian error / merah, terus tekan import)

class MainActivity : AppCompatActivity() {

    private val list = ArrayList<Hero>()
    private var title = "Mode List"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_heroes.setHasFixedSize(true)

        list.addAll(getListHeroes())
        showRecyclerList()
        setActionBarTitle(title)
    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

    private fun showRecyclerList() {
        rv_heroes.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(list)
        rv_heroes.adapter = listHeroAdapter
    }

    private fun getListHeroes(): ArrayList<Hero> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)

        val listHero = ArrayList<Hero>()
        for (position in dataDescription.indices) {
            val hero = Hero(
                    dataName[position],
                    dataDescription[position],
                    dataPhoto[position]
            )
            listHero.add(hero)
        }
        return listHero
    }
}