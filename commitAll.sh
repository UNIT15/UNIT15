echo "Commit comment:"
read comment

git pull

git add .
git commit -a -m "$comment"
git push

read -p "Press [Enter] to exit..."
