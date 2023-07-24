package ru.netology.coroutines.dto

data class PostsWithAuthorsAndComments(
    val post: Post,
    val comments: List<CommentWithAuthor>,
    val authors: Map<Long, Author> = mapOf()
) {
    private val authorsId: MutableSet<Long> = mutableSetOf()

    init {
        authorsId.add(post.authorId)
        for (i in 0..comments.lastIndex) {
            authorsId.add(comments[i].comment.authorId) //добавляем в коллекцию id авторов id авторов комментариев
        }
    }
    fun getAuthorsId() : List<Long> = authorsId.toList()
}
