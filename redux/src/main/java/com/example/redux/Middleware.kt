package com.example.redux

typealias Middleware<State> = (store: Store<State>) -> (next: Dispatch) -> Dispatch

fun <State> createMiddleware(
    middleware: (store: Store<State>, next: Dispatch, action: Action) -> Any
): Middleware<State> = { store ->
    { next ->
        { action ->
            middleware(store, next, action)
        }
    }
}

fun <State> applyMiddleware(
    middlewares: List<Middleware<State>>
): StoreEnhancer<State> = { storeCreator ->
    { reducer, initialState, enhancer ->
        val store = storeCreator(reducer, initialState, enhancer)
        val originalDispatch = store.dispatch
        val chain = middlewares.map { middleware -> middleware(store) }
        val dispatch = chain.foldRight(originalDispatch) { next, prev -> next(prev) }
        store.dispatch = dispatch
        store
    }
}