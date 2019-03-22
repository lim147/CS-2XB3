import urllib.request
import json
# maps.googleapis.com/maps/api/directions/json?origin=Disneyland&destination=Universal+Studios+Hollywood&key=AIzaSyB2-4HW3uo2_UIR6-XCL5EqvqzucNS1O_I
endpoint = "https://maps.googleapis.com/maps/api/directions/json?"
api_key = "AIzaSyB2-4HW3uo2_UIR6-XCL5EqvqzucNS1O_I"
origin = input("Where are you?: ").replace(" ", "+")
destination = input("Where do you want to go? ").replace(" ", "+")
nav_request = "origin={}&destination={}&key={}".format(
    origin, destination, api_key)
request = endpoint + nav_request
response = urllib.request.urlopen(request).read()
directions = json.loads(response)

#for x in directions:
#    print(x)

print(directions["routes"])
