package com.ijlsa.poptoons.ui.data

import com.ijlsa.poptoons.ui.model.Serie

object temp_data {
    val seriesList = mutableListOf(
        Serie(
            title = "Bob Esponja",
            description = "Vive en una piña debajo del mar!",
            imageUrl_Presentation = "https://images-na.ssl-images-amazon.com/images/S/pv-target-images/78beb6024e32d6511e887425756f9656a3d2439ccb11400d9b52476f4194d4c2._SX1080_.jpg",
            imageUrl_Preview = "https://static.wikia.nocookie.net/bobesponja/images/c/c9/Bob_Esponja_personajes_principales.png",
            seasons = 13,
            episodes = mutableListOf(mutableListOf("Episodio 1", "Eposidio 2", "Episodio 3"),
                                        mutableListOf("Episodio 1", "Eposidio 2", "Episodio 3"),
                                        mutableListOf("Episodio 1", "Eposidio 2")
                                    ),
            genders = mutableListOf("Comedia", "Infantil"),
            publication_year = 1999
        ),
        Serie(
            title = "CatDog",
            description = "Un gato y un perro siameses comparten el mismo cuerpo...",
            imageUrl_Presentation = "http://cdn5.upsocl.com/wp-content/uploads/2018/07/Captura-de-pantalla-2017-07-10-a-las-9.14.57-a.m..jpg",
            imageUrl_Preview = "https://images-ext-1.discordapp.net/external/YtNWpHqMdAoTKOfRQXCamVhtjlGaY86o6VS7upP5bQA/%3Fimage-profile%3Dimage_full%26io%3Dlandscape/https/10play.com.au/ip/s3/2021/04/27/4e06f398a94527274dbd4aa2267f5ee1-1051874.jpg",
            seasons = 4,
            episodes = mutableListOf(mutableListOf("Episodio 1", "Eposidio 2", "Episodio 3"),
                mutableListOf("Episodio 1", "Eposidio 2", "Episodio 3"),
                mutableListOf("Episodio 1", "Eposidio 2")
            ),
            genders = mutableListOf("Comedia", "Humor negro"),
            publication_year = 2005
        ),
        Serie(
            title = "Laboratorio de Dexter",
            description = "Dexter es un pequeño superdotado...",
            imageUrl_Presentation = "http://3.bp.blogspot.com/-cu0vowTIjn8/ToiDVtcZbJI/AAAAAAAAPYM/e1w1i4aJsrs/s1600/Dexter+Laboratory.jpg",
            imageUrl_Preview = "https://media.discordapp.net/attachments/897213665294581831/897221709512466472/tileburnedin.png",
            seasons = 4,
            episodes = mutableListOf(mutableListOf("Episodio 1", "Eposidio 2", "Episodio 3"),
                mutableListOf("Episodio 1", "Eposidio 2", "Episodio 3"),
                mutableListOf("Episodio 1", "Eposidio 2")
            ),
            genders = mutableListOf("Comedia", "Aventura", "Ciencia Ficción", "Infantil"),
            publication_year = 2003
        ),
        Serie(
            title = "Rick and Morty",
            description = "Rick Sanchez llega de imprevisto...",
            imageUrl_Presentation = "https://bloygo.yoigo.com/embed/0fe1e3ce91d9ee24922cdf4a4195d335d680a97a1533116852/portada_Rick_y_Morty.jpg",
            imageUrl_Preview = "https://i2.wp.com/www.generacionfriki.es/wp-content/uploads/2015/10/Rick-y-Morty-PORTADA.jpg",
            seasons = 5,
            episodes = mutableListOf(mutableListOf("Episodio 1", "Eposidio 2", "Episodio 3"),
                mutableListOf("Episodio 1", "Eposidio 2", "Episodio 3"),
                mutableListOf("Episodio 1", "Eposidio 2")
            ),
            genders = mutableListOf("Comedia", "Aventura", "Ciencia Ficción", "Humor negro"),
            publication_year = 2013
        )
    )
}