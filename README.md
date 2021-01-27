# Android Coroutine Playground
Explore Kotlin Coroutine Possibility

## Explore List
- [x] Basic suspend function
- [ ] Scopes
- [ ] Coroutine Unit Test
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
