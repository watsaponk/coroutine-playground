# Android Coroutine Playground
Explore Kotlin Coroutine Possibility

## Explore List
- [x] Basic suspend function
- [ ] Scopes
- [x] Coroutine Unit Test
- [ ] Flow & Channel
- [ ] Async
- [ ] Integrate with RxJava
- [ ] Feature Comparison with RxJava
  - [ ] Completable
  - [ ] Zip
  - [ ] Merge
  - [ ] Debounce & Delay

## Result
#### Basic suspend function
**suspend** (sus·pend, /səˈspend/) - temporarity prevent from continuing or being in force or effect
- can invoke by another suspend function or within coroutine
- it like pause and resume (not blocking thread)
- sequential function
- complie to function with callback interface `Continuation<T>`
```kotlin
public interface Continuation<in T> {
    /**
     * The context of the coroutine that corresponds to this continuation.
     */
    public val context: CoroutineContext

    /**
     * Resumes the execution of the corresponding coroutine passing a successful or failed [result] as the
     * return value of the last suspension point.
     */
    public fun resumeWith(result: Result<T>)
}
```
---
#### Coroutine unit Test
In my opinoin testing coroutine can saparate into 2 category
- Testing `ViewModel`
  - You have to stub `TestCoroutineDispatcher` into `Dispatchers.setMain(dispatcher: CoroutineDispatcher)` at call `resetMain()` after done testing
- Testing basic `suspend` function
  - For basic `suspend` function can be done the same way, if you run it on main thread.
  - For `IO` or other thread except main you should create coroutine context provider and stub it when testing
  ```kotlin
  interface CoroutineContextProvider {

      val Main: CoroutineContext

      val IO: CoroutineContext

  }
  ```
