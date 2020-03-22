echo "-----------------------------------"
echo "---- Attempting to compile... -----"
echo "-----------------------------------"
for file in *.java; do
	javac $file
	if (($?)); then
		echo "${file} failed to compile." >&2
		exit 1
	else 
		echo "${file} compiled successfully."
	fi
		echo "-----------------------------------"
done
exit 0