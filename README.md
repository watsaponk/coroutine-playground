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
|Subject|Result|
|---|---|
|Basic suspend function|**suspend** - temporarity prevent from continuing or being in force or effect<br><br><ul><li>can invoke by another suspend function or within coroutine</li><li>it like pause and resume (not blocking thread)</li><li>sequential function</li><li>complie to function with callback interface `Continuation<T>`</li></ul>|
