import urllib.request
import json
import sys
endpoint = "https://maps.googleapis.com/maps/api/directions/json?"
api_key = "AIzaSyB2-4HW3uo2_UIR6-XCL5EqvqzucNS1O_I"
# origin = sys.argv[1].replace(" ", "+")
origin = "Scotiabank+Arena,+40+Bay+St,+Toronto"
# destination = sys.argv[2].replace(" ", "+")
destination = "33+Dundurn+St+S,+Hamilton"
destination = "Pearson+Airport,+Mississauga"
nav_request = "origin={}&destination={}&key={}&alternatives=true".format(
    origin, destination, api_key)
request = endpoint + nav_request
response = urllib.request.urlopen(request).read()
directions = json.loads(response)

# for x in directions:
#   print(x)
order = []
# for x in directions["routes"][0]:
#   order.append(x)

# for x in directions["routes"][0]["legs"][0]["steps"]:
#   print(x)

# print("first")
# print(directions["routes"][0]["legs"][0]["duration"])
# print(directions["routes"][0]["legs"][0]["distance"])
# print("second")
# print(directions["routes"][1]["legs"][0]["duration"])
# print(directions["routes"][1]["legs"][0]["distance"])
# print("third")
# print(directions["routes"][2]["legs"][0]["duration"])
# print(directions["routes"][2]["legs"][0]["distance"])
# print(len(directions["routes"]))

# print(len(directions["routes"]))

for i in range(len(directions["routes"])):
    for x in directions["routes"][i]["legs"][0]["steps"]:
        print("{},{},{}".format(x["start_location"]["lat"],
                                x["start_location"]["lng"], x["html_instructions"]))
    print("new path")

# new
# for x in directions["routes"][0]:
#     print(x)

# for x in directions["routes"][1]:
#     print(x)

# print(type(directions["routes"]))

# for x in directions["routes"]:
#     print(x)

# print(directions["routes"])
