package ru.kozirfm.translator.model.data

import com.google.gson.annotations.SerializedName
import ru.kozirfm.translator.model.data.Meanings

class SearchResult(
    @field:SerializedName("text") val text: String?,
    @field:SerializedName("meanings") val meanings: List<Meanings>?
)
