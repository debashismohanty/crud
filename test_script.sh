
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{"id": 1, "name": "One"}' 'http://localhost:4000/crud/objects'
echo 'Object created'
curl -X GET --header 'Content-Type: application/json' --header 'Accept: application/json' 'http://localhost:4000/crud/objects/1'
echo 'Got created object'
curl -X PUT --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{"id": 1,"name": "One_1"}' 'http://localhost:4000/crud/objects/1'
echo 'Updating object'
curl -X GET --header 'Content-Type: application/json' --header 'Accept: application/json' 'http://localhost:4000/crud/objects/1'
echo 'Got updated object'
