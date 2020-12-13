package ru.kozirfm.translator.di

import dagger.Module
import dagger.Provides
import ru.kozirfm.translator.model.data.SearchResult
import ru.kozirfm.translator.model.repository.Repository
import ru.kozirfm.translator.view.main.MainInteractor
import javax.inject.Named

@Module
class InteractorModule {

    @Provides
    internal fun provideInteractor(
        @Named(NAME_REMOTE) repositoryRemote: Repository<List<SearchResult>>,
        @Named(NAME_LOCAL) repositoryLocal: Repository<List<SearchResult>>
    ) = MainInteractor(repositoryRemote, repositoryLocal)
}
