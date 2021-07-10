bucket_name=$1
aws_key=$2
aws_access_key=$3
aws_access_secret=$4
local_path=$5

echo "Inside release.sh"
pwd
ls -a

rm -rf $local_path

# Create a zip of the current directory.
zip -r $local_path .ebextensions target/tickettracker-b-0.0.1-SNAPSHOT.jar
echo "-------------ZipDone------------"
ls -a

# Install required dependencies for Python script.
pip3 install boto3

# Run upload script
#python3 scripts/upload_file_to_s3.py $bucket_name $aws_key $aws_access_key $aws_access_secret $local_path
