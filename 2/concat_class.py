import Pyro5.api

@Pyro5.api.expose
class Concat:
    def concat_strings(self, str1, str2):
        return str1 + str2