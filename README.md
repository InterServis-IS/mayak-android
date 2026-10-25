# Маяк VPN для Android

Приложение сервиса «Маяк VPN» (бот [@mayakprobot](https://t.me/mayakprobot)). Основано на открытом клиенте
[v2rayNG](https://github.com/2dust/v2rayNG) (ядро [Xray](https://github.com/XTLS/Xray-core)) и распространяется по той же
лицензии GPL-3.0 — исходный код открыт, см. [LICENSE](LICENSE).

## Что изменено относительно v2rayNG
- Название «Маяк VPN», значок маяка, пакет `com.mayakvpn.app`.
- Вход одной кнопкой из бота: ссылка `mayakvpn://install-sub?url=<ссылка подписки>`.
- Подписка обновляется сама раз в час и сразу после добавления.
- Приложение представляется панели как `MayakVPN/<версия>` — панель отдаёт полные настройки с серверами «Авто» и
  маршрутами (российские сайты напрямую).
- Проверка обновлений и ссылки — на этот репозиторий и бота.

## Сборка
Собирается автоматически на GitHub при каждом изменении в `main` (Actions → «Сборка APK»).
Свежий тестовый APK всегда здесь:
- для любого телефона: https://github.com/InterServis-IS/mayak-android/releases/download/test-latest/MayakVPN-test.apk
- поменьше (большинство современных телефонов): https://github.com/InterServis-IS/mayak-android/releases/download/test-latest/MayakVPN-test-arm64.apk

Подпись: если в секретах репозитория есть `MAYAK_KEYSTORE_BASE64`, `MAYAK_KEYSTORE_PASSWORD`, `MAYAK_KEY_ALIAS`,
`MAYAK_KEY_PASSWORD` — APK подписывается этим ключом (для выпуска). Иначе — тестовым ключом `V2rayNG/test-signing.keystore`
(только для тестов: при переходе на настоящий ключ приложение нужно будет переустановить один раз).
