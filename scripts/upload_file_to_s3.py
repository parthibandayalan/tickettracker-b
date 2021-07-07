import boto3
import sys
import os

def main():
    print(len(sys.argv))
    if (len(sys.argv) != 6):
        print ('Error: Required 5 arguments.')
        # Checks for 6 because the script path is in position 0. So len is 6
        # for 5 arguments.
        sys.exit(1)

    print("Upload to S3 python script initiated")
    #print(    os.system('ls -a target/tickettracker-b-0.0.1-SNAPSHOT.jar'))
    bucket_name=sys.argv[1]
    aws_key=sys.argv[2]
    aws_access_key=sys.argv[3]
    aws_access_secret=sys.argv[4]
    local_path=sys.argv[5]

    session = boto3.Session(
        aws_access_key_id=aws_access_key,
        aws_secret_access_key=aws_access_secret,
    )
    client = session.client('s3')

    os.system('ls -l')
    os.system('ls -l target')
    os.system('pwd')

    response = client.upload_file(
        Filename=local_path,
        Bucket=bucket_name,
        Key=aws_key
    )
    print ('Done uploading')


main()
