# コマンド

- git

  - main ブランチに戻る
    git checkout main
  - リモートの main ブランチをローカルの main ブランチへ
    git pull origin main
  - ブランチを切る
    git checkout -b feature/xxxxxx
  - ステージング
    git add .
  - コミット
    git commit -m "commit message"
  - プッシュ
    git push origin feature/xxxxxx

- backend
  - backend へ移動<br>
    cd backend/api
  - DB ユーザー名、パスワードの環境変数設定
    $env:DB_PASSWORD="DB ユーザー名"
    $env:DB_PASSWORD="DB パスワード"
  - maven コンパイル
    mvn clean compile
  - Spring 起動<br>
    .\mvnw.cmd spring-boot:run
