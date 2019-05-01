:: 用于提价变更内容
:: author: houbb
:: LastUpdateTime:  2019-5-1 20:16:31
:: 用法：双击运行，或者当前路径 cmd 直接输入 cgit.bat

:: 开启回显
@echo ON

ECHO "============================= Git push START..."
git pull
git add .
git commit -m "[update] updates"
git push
git status
ECHO "============================= Git push END..."

