# 目的
- とりあえずAndroidでHTTP通信がしたかった
- retrofit2を用いたPOSTのtest用project
- ホントは非同期処理とかreactとかすべきな気もする

*** コードとか命名とかはあんまり参考にしないように ***

# 雑な構成
## Activity:Sub→Mainと遷移
- Sub :画面遷移＋IP指定のtest
- Main:POSTのtest
## Retrofit(package)
- PostBody
    - postする形式を指定するClass
    - 直接JSONObjectを投げるのがうまくいかなくって，クラスObjectとして投げたら上手く出来た
- HTTP_Interface
    - HTTP通信の記述をするInterface
    - ここでObjectの形式も指定する（JSONとか特定のClassとか）
    - formとかも指定できるけど，POSTは無理っぽい？
- RetrofitClient
    - 上のInterfaceで記述したメソッドを実行する
    - 投げる形式が決まっているためここでクラス化しといたら，実際に使いたい時はインスタンスを生成，メソッドを実行するだけになる