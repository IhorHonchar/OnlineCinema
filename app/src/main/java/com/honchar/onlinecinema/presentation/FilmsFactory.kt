package com.honchar.onlinecinema.presentation

import android.content.Context
import com.honchar.onlinecinema.R
import com.honchar.onlinecinema.core.views.FilmsCategory
import com.honchar.onlinecinema.presentation.account.model.UserDataModel
import com.honchar.onlinecinema.presentation.filmDetails.model.ActorModel
import com.honchar.onlinecinema.presentation.filmDetails.model.CategoryModel

object FilmsFactory {
    private val venom = FilmsCategory.Film(
        filmId = "1",
        filmName = "Venom",
        filmPoster = "https://m.media-amazon.com/images/M/MV5BNTFkZjdjN2QtOGE5MS00ZTgzLTgxZjAtYzkyZWQ5MjEzYmZjXkEyXkFqcGdeQXVyMTM0NTUzNDIy._V1_SX300.jpg",
        filmRate = "6.6",
        desc = "A failed reporter is bonded to an alien entity, one of many symbiotes who have invaded Earth. But the being takes a liking to Earth and decides to protect it.",
        actors = listOf(
            ActorModel(
                "",
                "Tom Hardy",
                "https://upload.wikimedia.org/wikipedia/commons/7/73/Tom_Hardy_Cannes_2015.jpg"
            ),
            ActorModel(
                "",
                "Rizwan «Riz» Ahmed",
                "https://static.kinoafisha.info/k/persons/220/upload/persons/716692038867.jpg"
            ),
            ActorModel(
                "",
                "Michelle Ingrid Williams",
                "https://uznayvse.ru/images/catalog/2022/2/michelle-williams_96.jpg"
            ),
            ActorModel(
                "",
                "Woodrow Tracy",
                "https://www.film.ru/sites/default/files/styles/thumb_260x320/public/people/1456632-1436874.jpg"
            )
        ),
        categories = listOf(
            CategoryModel(
                id = "1",
                name = R.string.category_action
            ),
            CategoryModel(
                id = "2",
                name = R.string.category_comedy
            ),
            CategoryModel(
                id = "4",
                name = R.string.category_16
            ),
        )
    )
    private val spiderMan = FilmsCategory.Film(
        filmId = "2",
        filmName = "Spider-Man",
        filmPoster = "https://m.media-amazon.com/images/M/MV5BZDEyN2NhMjgtMjdhNi00MmNlLWE5YTgtZGE4MzNjMTRlMGEwXkEyXkFqcGdeQXVyNDUyOTg3Njg@._V1_SX300.jpg",
        filmRate = "7.4",
        desc = "Based on Marvel Comics' superhero character, this is a story of Peter Parker who is a nerdy high-schooler. He was orphaned as a child, bullied by jocks, and can't confess his crush for his stunning neighborhood girl Mary Jane Watson. To say his life is \\\"miserable\\\" is an understatement. But one day while on an excursion to a laboratory a runaway radioactive spider bites him... and his life changes in a way no one could have imagined. Peter acquires a muscle-bound physique, clear vision, ability to cling to surfaces and crawl over walls, shooting webs from his wrist ... but the fun isn't going to last. An eccentric millionaire Norman Osborn administers a performance enhancing drug on himself and his maniacal alter ego Green Goblin emerges. Now Peter Parker has to become Spider-Man and take Green Goblin to the task... or else Goblin will kill him. They come face to face and the war begins in which only one of them will survive at the end.",
        actors = listOf(
            ActorModel(
                "",
                "Tobias Vincent Maguire",
                "https://www.thevoicemag.ru/upload/img_cache/cf9/cf920b799a88d3c11358dc47a9a4c763_cropped_308x411.jpg"
            ),
        ),
        categories = listOf(
            CategoryModel(
                id = "1",
                name = R.string.category_action
            ),
            CategoryModel(
                id = "2",
                name = R.string.category_comedy
            ),
        ),
    )
    private val indiana = FilmsCategory.Film(
        filmId = "3",
        filmName = "Indiana Jones and the Raiders of the Lost Ark",
        filmPoster = "https://m.media-amazon.com/images/M/MV5BNTU2ODkyY2MtMjU1NC00NjE1LWEzYjgtMWQ3MzRhMTE0NDc0XkEyXkFqcGdeQXVyMjM4MzQ4OTQ@._V1_SX300.jpg",
        filmRate = "8.4",
        desc = "The year is 1936. An archeology professor named Indiana Jones is venturing in the jungles of South America searching for a golden statue. Unfortunately, he sets off a deadly trap but miraculously escapes. Then, Jones hears from a museum curator named Marcus Brody about a biblical artifact called The Ark of the Covenant, which can hold the key to human existence. Jones has to venture to vast places such as Nepal and Egypt to find this artifact. However, he will have to fight his enemy Rene Belloq and a band of Nazis in order to reach it.",
        actors = listOf(
            ActorModel(
                "",
                "Harrison Ford",
                "https://www.kinonews.ru/insimgs/persimg/persimg23.jpg"
            ),
            ActorModel(
                "",
                "Karen Allen",
                "https://www.film.ru/sites/default/files/persones/_imported/0000261.jpg"
            ),
            ActorModel("", "Paul Freeman", "http://www.kinofilms.ua/images/person/big/5679.jpg")
        ),
        categories = listOf(
            CategoryModel(
                id = "6",
                name = R.string.category_fantasy
            ),
            CategoryModel(
                id = "2",
                name = R.string.category_comedy
            ),
        )
    )
    private val start = FilmsCategory.Film(
        filmId = "4",
        filmName = "Star Wars",
        filmPoster = "https://m.media-amazon.com/images/M/MV5BNzg4MjQxNTQtZmI5My00YjMwLWJlMjUtMmJlY2U2ZWFlNzY1XkEyXkFqcGdeQXVyODk4OTc3MTY@._V1_SX300.jpg",
        filmRate = "8.6",
        desc = "he Imperial Forces, under orders from cruel Darth Vader, hold Princess Leia hostage in their efforts to quell the rebellion against the Galactic Empire. Luke Skywalker and Han Solo, captain of the Millennium Falcon, work together with the companionable droid duo R2-D2 and C-3PO to rescue the beautiful princess, help the Rebel Alliance and restore freedom and justice to the Galaxy.",
        actors = listOf(
            ActorModel(
                "",
                "Mark Richard Hamill",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/6/68/Mark_Hamill_by_Gage_Skidmore_2.jpg/1200px-Mark_Hamill_by_Gage_Skidmore_2.jpg"
            ),
            ActorModel(
                "",
                "Carrie Frances Fisher",
                "https://ichef.bbci.co.uk/news/640/cpsprodpb/26FD/production/_93118990_mediaitem93118989.jpg"
            )
        ),
        categories = listOf(
            CategoryModel(
                id = "6",
                name = R.string.category_fantasy
            ),
            CategoryModel(
                id = "1",
                name = R.string.category_action
            ),
            CategoryModel(
                id = "4",
                name = R.string.category_16
            ),
        )
    )
    private val titanic = FilmsCategory.Film(
        filmId = "5",
        filmName = "Titanic",
        desc = "84 years later, a 100 year-old woman named Rose DeWitt Bukater tells the story to her granddaughter Lizzy Calvert, Brock Lovett, Lewis Bodine, Bobby Buell and Anatoly Mikailavich on the Keldysh about her life set in April 10th 1912, on a ship called Titanic when young Rose boards the departing ship with the upper-class passengers and her mother, Ruth DeWitt Bukater, and her fiancé, Caledon Hockley. Meanwhile, a drifter and artist named Jack Dawson and his best friend Fabrizio De Rossi win third-class tickets to the ship in a game. And she explains the whole story from departure until the death of Titanic on its first and last voyage April 15th, 1912 at 2:20 in the morning.\",\"Language",
        filmPoster = "https://m.media-amazon.com/images/M/MV5BMDdmZGU3NDQtY2E5My00ZTliLWIzOTUtMTY4ZGI1YjdiNjk3XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_SX300.jpg",
        filmRate = "7.9",
        actors = listOf(
            ActorModel(
                "",
                "Kate Elizabeth Winslet",
                "https://thumbs.dfs.ivi.ru/storage26/contents/b/a/61575dad7aeddd4e69b6e04f6dac8b.jpg"
            ),
            ActorModel(
                "",
                "Leonardo Wilhelm DiCaprio",
                "https://elle.ua/upload/file/gettyimages-1205143953.jpg"
            ),
            ActorModel(
                "",
                "William George (Billy) Zane Jr.",
                "https://thumbs.dfs.ivi.ru/storage38/contents/a/0/42055c33dfb1f00fd71779b90529a7.jpg"
            ),
            ActorModel(
                "",
                " Kathleen Doyle Bates",
                "https://thumbs.dfs.ivi.ru/storage33/contents/a/c/cb2ce65c899ed16fd2185ac7cba7e6.jpg"
            )
        ),
        categories = listOf(
            CategoryModel(
                id = "3",
                name = R.string.category_drama
            ),
            CategoryModel(
                id = "4",
                name = R.string.category_16
            ),
        )
    )
    private val fast = FilmsCategory.Film(
        filmId = "6",
        filmName = "The Fast and the Furious",
        filmPoster = "https://m.media-amazon.com/images/M/MV5BNzlkNzVjMDMtOTdhZC00MGE1LTkxODctMzFmMjkwZmMxZjFhXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SX300.jpg",
        desc = "Los Angeles street racer Dominic Toretto falls under the suspicion of the LAPD as a string of high-speed electronics truck robberies rocks the area. Brian O'Connor, an officer of the LAPD, joins the ranks of Toretto's highly skilled racing crew undercover to convict Toretto. However, O'Connor finds himself both enamored with this new world and in love with Toretto's sister, Mia. As a rival racing crew gains strength, O'Connor must decide where his loyalty really lies.",
        filmRate = "6.8",
        actors = listOf(
            ActorModel(
                "",
                "Vin Diesel",
                "https://www.film.ru/sites/default/files/people/1456556-880555.jpg"
            ),
            ActorModel(
                "",
                "Paul Walker",
                "https://www.film.ru/sites/default/files/people/photo_80.jpg"
            )
        ),
        categories = listOf(
            CategoryModel(
                id = "1",
                name = R.string.category_action
            ),
        ),
        isLike = true
    )
    private val morbius = FilmsCategory.Film(
        filmId = "7",
        filmName = "Morbius",
        filmPoster = "https://m.media-amazon.com/images/M/MV5BNTA3N2Q0ZTAtODJjNy00MmQzLWJlMmItOGFmNDI0ODgxN2QwXkEyXkFqcGdeQXVyMTM0NTUzNDIy._V1_SX300.jpg",
        desc = "Dangerously ill with a rare blood disorder, and determined to save others suffering his same fate, Dr. Morbius attempts a desperate gamble. What at first appears to be a radical success soon reveals itself to be a remedy potentially worse than the disease.",
        filmRate = "5.1",
        actors = listOf(
            ActorModel(
                "",
                "Jared Leto",
                "https://upload.wikimedia.org/wikipedia/commons/2/24/Jared_Leto_by_Gage_Skidmore.jpg"
            ),
            ActorModel(
                "",
                "Matt Smith",
                "https://www.film.ru/sites/default/files/people/1575291-1681554.jpg"
            )
        ),
        categories = listOf(
            CategoryModel(
                id = "6",
                name = R.string.category_fantasy
            ),
            CategoryModel(
                id = "1",
                name = R.string.category_action
            ),
        ),
        isLater = true
    )

    fun getFilms(): List<FilmsCategory.Film> {
        return listOf(venom, spiderMan, indiana, start, titanic, fast, morbius)
    }

    fun getCategories(): List<CategoryModel> {
        return listOf(
            CategoryModel(
                id = "1",
                name = R.string.category_action
            ),
            CategoryModel(
                id = "2",
                name = R.string.category_comedy
            ),
            CategoryModel(
                id = "3",
                name = R.string.category_drama
            ),
            CategoryModel(
                id = "4",
                name = R.string.category_16
            ),
            CategoryModel(
                id = "5",
                name = R.string.category_history
            ),
            CategoryModel(
                id = "6",
                name = R.string.category_fantasy
            )
        )
    }

    val userData = UserDataModel(
        avatar = "https://itc.ua/wp-content/uploads/2020/04/android_logo_stacked__rgb_.5.jpg",
        fullName = "Honchar Ihor",
        email = "ihor693@gmail.com"
    )
}