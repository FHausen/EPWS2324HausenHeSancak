package com.example.algorithmuspoc

import kotlin.math.abs


enum class Genre{
    Abstract,
    Children,
    Customizable,
    Family,
    Party,
    Strategy,
    Thematic,
    Wargame
}

class User(
    var userId: Int,
    var location: String,
    var genre: List<Genre>,
    var age: Int,
    var experience: Int,
    var searched: List<String>,
    var gameHistory: List<Int>
)

class UserSimilarity(
    var user: User,
    var similarity: Int
)

class Game(
    var gameId: Int,
    var genre: List<Genre>,
    var age: Int,
    var complexity: Int,
    var views: Int
)

class GameSimilarity(
    var game: Game,
    var similarity: Int
)

class Group(
    var groupId: Int,
    var location: String,
    var genre: List<Genre>,
    var age: Int,
    var experience: Int
)

class GroupFitting(
    var group: Group,
    var similarity: Int
)


//vergleicht zwei Nutzer und gibt ein Int als Wert für Ähnlichkeit zurück
fun getUserSimilarity(user1: User, user2: User):Int{

    var similarity = 0
    var genreSimilarity = 0

    if (user1.location==user2.location) similarity += 1
    if (abs(user1.age-user2.age)<=5 ) similarity += 1
    if (user1.experience==user2.experience) similarity += 1
    user1.genre.forEach {
        if (user2.genre.contains(it)){
            similarity += 1
            genreSimilarity += 1
        }
    }
    user1.gameHistory.forEach {
        if (user2.gameHistory.contains(it)){
            similarity += 1
            genreSimilarity += 1
        }
    }

    return if (similarity>=3&&genreSimilarity>=1){
        similarity
    }
    else 0
}


//vergleicht zwei Spiele und gibt ein Int als Wert für Ähnlichkeit zurück
fun getGameSimilarity(game1: Game, game2: Game):Int{

    var similarity = 0
    var genreSimilarity = 0

    if (abs(game1.age-game2.age)<=2 ) similarity += 1
    if (game1.complexity==game2.complexity) similarity += 1
    game1.genre.forEach {
        if (game2.genre.contains(it)){
            similarity += 1
            genreSimilarity += 1
        }
    }

    return if (similarity>=2&&genreSimilarity>=1){
        similarity
    }
    else 0
}


//vergleicht einen Nutzer und eine gruppe und gibt ein Int als Wert für Ähnlichkeit zurück
fun getFittingGroup(user: User, group: Group):Int{

    var similarity = 0
    var genreSimilarity = 0

    if (user.location==group.location) similarity += 2
    if (abs(user.age-group.age)<=5 ) similarity += 1
    if (user.experience==group.experience) similarity += 1
    user.genre.forEach {
        if (group.genre.contains(it)){
            similarity += 1
            genreSimilarity += 1
        }
    }

    return if (similarity>=3&&genreSimilarity>=1||user.location==group.location){
        similarity
    }
    else 0
}



//Testnutzer, userId 0 testet den Fall wenn es zu keiner Empfehlung kommt
val userList = listOf<User>(
    User(0,"", listOf(),0,0, listOf(), listOf()),
    User(1,"Köln", listOf(Genre.Abstract,Genre.Strategy,Genre.Thematic,Genre.Wargame),23,1, listOf(), listOf(2,17,29,31,37,44,47)),
    User(2,"Köln", listOf(Genre.Party,Genre.Strategy,Genre.Thematic),34,2, listOf(), listOf(5,8,19,27,39,45)),
    User(3,"Köln", listOf(Genre.Family,Genre.Abstract),54,4, listOf(), listOf(1,15,24,30)),
    User(4,"Köln", listOf(Genre.Abstract,Genre.Customizable,Genre.Party,Genre.Strategy,Genre.Thematic),34,4, listOf(), listOf(9,5,11,17,20,27,33,31,42,50)),
    User(5,"Köln", listOf(Genre.Thematic,Genre.Wargame),50,3, listOf(), listOf(7,11,27,39,42,48)),
    User(6,"Köln", listOf(Genre.Children,Genre.Family),24,1, listOf(), listOf(3,19,26,41)),
    User(7,"Hamburg", listOf(Genre.Family,Genre.Thematic),34,2, listOf(), listOf(49,26)),
    User(8,"Hamburg", listOf(Genre.Strategy,Genre.Wargame),43,4, listOf(), listOf(43,48,29,22)),
    User(9,"Hamburg", listOf(Genre.Customizable,Genre.Party),22,1, listOf(), listOf(31,45,23,19,14,10)),
    User(10,"Hamburg", listOf(Genre.Family,Genre.Strategy,Genre.Thematic),34,5, listOf(), listOf(15,8,18,35,49)),
    User(11,"Hamburg", listOf(Genre.Abstract,Genre.Children,Genre.Thematic),45,4, listOf(), listOf(50,39,26,21,5,3,4)),
    User(12,"Hamburg", listOf(Genre.Strategy,Genre.Wargame,Genre.Party),40,5, listOf(), listOf(11,2,18,20,29,38,47)),
    User(13,"Hamburg", listOf(Genre.Family,Genre.Strategy),37,1, listOf(), listOf(49,26,18)),
    User(14,"Hamburg", listOf(Genre.Children,Genre.Party),48,2, listOf(), listOf(3)),
    User(15,"Hamburg", listOf(Genre.Party,Genre.Customizable,Genre.Strategy),24,3, listOf(), listOf(19,26,30)),
    User(16,"München", listOf(Genre.Thematic,Genre.Customizable),29,2, listOf(), listOf(27,18,39)),
    User(17,"München", listOf(Genre.Abstract,Genre.Customizable,Genre.Strategy),20,5, listOf(), listOf(24,29,31,33,42,43,48)),
    User(18,"München", listOf(Genre.Thematic,Genre.Children),45,3, listOf(), listOf(7,18,27,42,49,11)),
    User(19,"München", listOf(Genre.Customizable,Genre.Strategy),61,3, listOf(), listOf(18,6,14,29)),
    User(20,"München", listOf(Genre.Abstract,Genre.Family),36,3, listOf(), listOf(50,9,10,28)),
    User(21,"München", listOf(Genre.Party,Genre.Strategy,Genre.Thematic),38,4, listOf(), listOf(20,14,8,5,1,45,27)),
    User(22,"Berlin", listOf(Genre.Strategy,Genre.Thematic),31,1, listOf(), listOf(22,27,18,13)),
    User(23,"Berlin", listOf(Genre.Party,Genre.Customizable),27,2, listOf(), listOf(14,5)),
    User(24,"Berlin", listOf(Genre.Strategy,Genre.Children),22,3, listOf(), listOf(8,29,37,48)),
    User(25,"Berlin", listOf(Genre.Party,Genre.Strategy),43,4, listOf(), listOf(35,22,14)),
    User(26,"Berlin", listOf(Genre.Customizable,Genre.Thematic),43,4, listOf(), listOf(18,6,8)),
    User(27,"Berlin", listOf(Genre.Customizable,Genre.Family),40,5, listOf(), listOf(1,14,29,44)),
    User(28,"Berlin", listOf(Genre.Wargame,Genre.Customizable,Genre.Family),23,5, listOf(), listOf(31,29,48,37,33,13)),
    User(29,"Berlin", listOf(Genre.Abstract,Genre.Party),19,5, listOf(), listOf(9,5,17,23,28,36)),
    User(30,"Berlin", listOf(Genre.Strategy,Genre.Wargame),23,3, listOf(), listOf(48,22,20,2)),
    User(31,"Berlin", listOf(Genre.Wargame,Genre.Children),36,3, listOf(), listOf(37,43)),
    User(32,"Berlin", listOf(Genre.Abstract,Genre.Customizable),38,1, listOf(), listOf(50)),
    User(33,"Frankfurt am Main", listOf(Genre.Thematic,Genre.Party),25,3, listOf(), listOf(27,11,8,29)),
    User(34,"Frankfurt am Main", listOf(Genre.Strategy,Genre.Thematic),21,4, listOf(), listOf(29,48,44,18,8)),
    User(35,"Frankfurt am Main", listOf(Genre.Family,Genre.Party),37,3, listOf(), listOf(1,4,15,23,19)),
    User(36,"Frankfurt am Main", listOf(Genre.Children,Genre.Family,Genre.Party,Genre.Thematic),46,3, listOf(), listOf(3,4,14,23,29,41,49)),
    User(37,"Frankfurt am Main", listOf(Genre.Strategy,Genre.Thematic),39,2, listOf(), listOf(39,44,18,8,2)),
    User(38,"Düsseldorf", listOf(Genre.Children,Genre.Thematic),25,2, listOf(), listOf(16)),
    User(39,"Düsseldorf", listOf(Genre.Abstract,Genre.Strategy,Genre.Thematic),24,4, listOf(), listOf(36,44,43,48,8,18,27)),
    User(40,"Düsseldorf", listOf(Genre.Strategy,Genre.Abstract),34,5, listOf(), listOf(11,27,29,37,48)),
    User(41,"Stuttgart", listOf(Genre.Strategy,Genre.Thematic),35,3, listOf(), listOf(48,50,44,29,6)),
    User(42,"Stuttgart", listOf(Genre.Children,Genre.Family,Genre.Party),38,2, listOf(), listOf(15,14,23,4,16)),
    User(43,"Stuttgart", listOf(Genre.Party,Genre.Wargame),53,2, listOf(), listOf(19,34,30)),
    User(44,"Bonn", listOf(Genre.Abstract,Genre.Children,Genre.Strategy),27,4, listOf(), listOf(50,1,4,28,24,17)),
    User(45,"Bonn", listOf(Genre.Family,Genre.Wargame),37,1, listOf(), listOf(49,26,21)),
    User(46,"Essen", listOf(Genre.Thematic,Genre.Children),26,5, listOf(), listOf(35,23,8,44,50)),
    User(47,"Essen", listOf(Genre.Customizable,Genre.Children),35,1, listOf(), listOf(29,31,25,1)),
    User(48,"Aachen", listOf(Genre.Abstract,Genre.Customizable,Genre.Party,Genre.Strategy),23,2, listOf(), listOf(8,9,10,14,50,43,48,22,18,13)),
    User(49,"Aachen", listOf(Genre.Strategy,Genre.Thematic),25,3, listOf(), listOf(8,18,7,27)),
    User(50,"Gummersbach", listOf(Genre.Customizable,Genre.Strategy,Genre.Thematic),30,3, listOf(), listOf(27,29,44,14,6)),
)



//Testspiele
val gameList = listOf<Game>(
    Game(1,listOf(Genre.Family,Genre.Customizable),10,2,435),
    Game(2,listOf(Genre.Customizable,Genre.Strategy),12,3,235),
    Game(3,listOf(Genre.Children),6,1,32),
    Game(4,listOf(Genre.Children,Genre.Family),6,1,346),
    Game(5,listOf(Genre.Party),12,3,624),
    Game(6,listOf(Genre.Customizable),16,4,2654),
    Game(7,listOf(Genre.Thematic),12,2,436),
    Game(8,listOf(Genre.Strategy,Genre.Thematic),16,5,1546),
    Game(9,listOf(Genre.Abstract),12,4,435),
    Game(10,listOf(Genre.Abstract),8,2,324),
    Game(11,listOf(Genre.Strategy,Genre.Thematic),14,5,34),
    Game(12,listOf(Genre.Abstract),8,3,67),
    Game(13,listOf(Genre.Strategy,Genre.Wargame),14,4,345),
    Game(14,listOf(Genre.Party,Genre.Customizable),10,3,756),
    Game(15,listOf(Genre.Family),8,2,1234),
    Game(16,listOf(Genre.Children,Genre.Family),6,1,546),
    Game(17,listOf(Genre.Abstract),8,2,976),
    Game(18,listOf(Genre.Strategy,Genre.Thematic),12,4,657),
    Game(19,listOf(Genre.Party),8,3,345),
    Game(20,listOf(Genre.Strategy),12,4,760),
    Game(21,listOf(Genre.Children,Genre.Family),6,1,540),
    Game(22,listOf(Genre.Strategy),12,5,432),
    Game(23,listOf(Genre.Party),12,1,2543),
    Game(24,listOf(Genre.Abstract),10,2,45),
    Game(25,listOf(Genre.Customizable),12,3,543),
    Game(26,listOf(Genre.Family),8,1,235),
    Game(27,listOf(Genre.Thematic),16,3,4654),
    Game(28,listOf(Genre.Abstract),8,2,476),
    Game(29,listOf(Genre.Wargame,Genre.Customizable),10,3,3765),
    Game(30,listOf(Genre.Party),12,2,456),
    Game(31,listOf(Genre.Wargame,Genre.Customizable),12,3,385),
    Game(32,listOf(Genre.Customizable),12,3,483),
    Game(33,listOf(Genre.Strategy),16,4,567),
    Game(34,listOf(Genre.Party),8,1,906),
    Game(35,listOf(Genre.Strategy,Genre.Thematic),12,4,467),
    Game(36,listOf(Genre.Abstract),8,2,3456),
    Game(37,listOf(Genre.Wargame),12,4,3540),
    Game(38,listOf(Genre.Abstract),10,2,56),
    Game(39,listOf(Genre.Thematic),14,2,578),
    Game(40,listOf(Genre.Abstract),12,2,678),
    Game(41,listOf(Genre.Children),6,1,75),
    Game(42,listOf(Genre.Strategy,Genre.Thematic),18,5,23),
    Game(43,listOf(Genre.Strategy,Genre.Wargame),14,5,643),
    Game(44,listOf(Genre.Customizable,Genre.Thematic),12,3,4356),
    Game(45,listOf(Genre.Party),14,2,879),
    Game(46,listOf(Genre.Abstract),10,1,234),
    Game(47,listOf(Genre.Strategy,Genre.Wargame),14,4,54),
    Game(48,listOf(Genre.Strategy,Genre.Thematic),14,4,2674),
    Game(49,listOf(Genre.Family),8,2,342),
    Game(50,listOf(Genre.Abstract),8,3,3289),
)



//Testgruppen
val groupList = listOf<Group>(
    Group(1,"Köln", listOf(Genre.Abstract,Genre.Customizable),25,1),
    Group(2,"Köln", listOf(Genre.Customizable),33,2),
    Group(3,"Köln", listOf(Genre.Children,Genre.Family),40,5),
    Group(4,"Köln", listOf(Genre.Strategy,Genre.Wargame),26,4),
    Group(5,"Köln", listOf(Genre.Children,Genre.Family),34,2),
    Group(6,"Köln", listOf(Genre.Party),43,3),
    Group(7,"Köln", listOf(Genre.Customizable),40,4),
    Group(8,"Hamburg", listOf(Genre.Strategy),41,1),
    Group(9,"Hamburg", listOf(Genre.Thematic,Genre.Wargame),35,1),
    Group(10,"Hamburg", listOf(Genre.Abstract),42,2),
    Group(11,"Hamburg", listOf(Genre.Strategy),45,3),
    Group(12,"Hamburg", listOf(Genre.Family,Genre.Party),34,1),
    Group(13,"Hamburg", listOf(Genre.Customizable,Genre.Wargame),26,5),
    Group(14,"Hamburg", listOf(Genre.Customizable),35,1),
    Group(15,"Hamburg", listOf(Genre.Abstract),30,2),
    Group(16,"Hamburg", listOf(Genre.Wargame),35,1),
    Group(17,"Hamburg", listOf(Genre.Thematic,Genre.Party),51,4),
    Group(18,"München", listOf(Genre.Abstract),30,5),
    Group(19,"München", listOf(Genre.Wargame),30,3),
    Group(20,"München", listOf(Genre.Children),32,4),
    Group(21,"München", listOf(Genre.Thematic),40,5),
    Group(22,"München", listOf(Genre.Family),19,1),
    Group(23,"München", listOf(Genre.Strategy),20,4),
    Group(24,"München", listOf(Genre.Strategy,Genre.Thematic),34,2),
    Group(25,"Berlin", listOf(Genre.Wargame),45,5),
    Group(26,"Berlin", listOf(Genre.Family),30,4),
    Group(27,"Berlin", listOf(Genre.Children),25,2),
    Group(28,"Berlin", listOf(Genre.Party),33,1),
    Group(29,"Berlin", listOf(Genre.Abstract),30,3),
    Group(30,"Berlin", listOf(Genre.Customizable,Genre.Party),33,5),
    Group(31,"Berlin", listOf(Genre.Wargame),42,1),
    Group(32,"Berlin", listOf(Genre.Customizable),40,4),
    Group(33,"Berlin", listOf(Genre.Children),34,5),
    Group(34,"Berlin", listOf(Genre.Abstract),47,5),
    Group(35,"Berlin", listOf(Genre.Party),30,1),
    Group(36,"Berlin", listOf(Genre.Family,Genre.Party),38,2),
    Group(37,"Berlin", listOf(Genre.Abstract,Genre.Strategy,Genre.Thematic),36,3),
    Group(38,"Frankfurt am Main", listOf(Genre.Wargame),30,2),
    Group(39,"Frankfurt am Main", listOf(Genre.Customizable),25,5),
    Group(40,"Frankfurt am Main", listOf(Genre.Wargame),30,1),
    Group(41,"Frankfurt am Main", listOf(Genre.Strategy),22,2),
    Group(42,"Frankfurt am Main", listOf(Genre.Customizable),31,4),
    Group(43,"Düsseldorf", listOf(Genre.Thematic),24,2),
    Group(44,"Düsseldorf", listOf(Genre.Abstract),28,5),
    Group(45,"Düsseldorf", listOf(Genre.Strategy,Genre.Thematic,Genre.Wargame),39,4),
    Group(46,"Düsseldorf", listOf(Genre.Customizable),41,3),
    Group(47,"Stuttgart", listOf(Genre.Abstract,Genre.Customizable,Genre.Thematic),40,1),
    Group(48,"Stuttgart", listOf(Genre.Family),39,2),
    Group(49,"Stuttgart", listOf(Genre.Party),55,1),
    Group(50,"Stuttgart", listOf(Genre.Abstract,Genre.Strategy,Genre.Thematic,Genre.Wargame),31,5),
)


