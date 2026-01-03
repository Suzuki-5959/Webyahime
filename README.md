# うぇぶや姫

宮乃やみ様(https://www.youtube.com/@miyanoyami)
Web 開発百本ノック(Web アプリ開発学習用プロジェクト)

## 構成

- backend : Spring Boot (API)
- docs : DB関連(定義書、DDL、DML)、検証用postmanコレクション、その他ドキュメント

## レビューについて

レビュー時は以下を参照していただけますと幸いです。

- Tag：lesson-X
- 手順

1. GitHub → Tags
2. lesson-X を選択
3. 「Browse files」

## 環境

- OS: Windows 11
- JDK: 17
- Build Tool: Maven 3.9.9
- Framework: Spring Boot 3.5.9
- DB: PostgreSQL 15
- IDE: VSCode

## 起動手順

postgreSQL にて以下のファイルの SQL を実行(初回時のみ)

- docs>DDL、DML

powershell 上にて以下を実行(※1,2 はお使いの PosgresSQL 環境に合わせてください。)

1. $env:DB_PASSWORD="DB ユーザー名"
2. $env:DB_PASSWORD="DB パスワード"
3. cd backend/api
4. mvn clean compile
5. .\mvnw.cmd spring-boot:run
