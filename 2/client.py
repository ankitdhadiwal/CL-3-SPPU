import Pyro5.api

# Replace with the actual URI from the server output
uri = input("Enter the URI of the remote object (from server): ")
proxy = Pyro5.api.Proxy(uri)

s1 = input("Enter first string: ")
s2 = input("Enter second string: ")

result = proxy.concat_strings(s1, s2)
print("Concatenated string:", result)