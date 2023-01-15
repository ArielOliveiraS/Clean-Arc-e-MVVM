Nesse projeto é apresentado uma lista de filmes com uma tela de detalhe usando a api TMDB, foi usado MVVM 
com Clean Architecture, Koin para injeção de dependência e Coroutines para gerenciamento de Threads.
Para o binding das views estou usando o synthetic, mas mudaria para o View binding ou Data binding 
para evitar erros de referência, também implementaria o mapper para que a camada de apresentação não
tivesse acesso direto a camada de dados, adicionaria também os loadings e tratamentos de erro.