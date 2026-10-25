# Маяк VPN Android — заметки для работы

- Форк v2rayNG (GPL-3.0). Kotlin-пакет оставлен `com.v2ray.ang` (от него зависит JNI в libhevtun), меняется только
  `applicationId = com.mayakvpn.app`. Обновления из апстрима — переносить вручную, точечно.
- Сборка только в GitHub Actions (`.github/workflows/build.yml`); локально чужие скрипты сборки не запускаем.
  Тестовый APK: Releases → `test-latest`.
- Изменения помечаем комментарием `Маяк:` в коде, чтобы легко находить при обновлении апстрима.
- Подписка из бота: `mayakvpn://install-sub?url=...`; UA `MayakVPN/<версия>` (в панели Remnawave — правило ответа XRAY_JSON).
