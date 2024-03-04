import sys

data = sys.argv[1]
try:
    result = eval(data)
    #with open("C:/Users/Dell/Documents/NetBeansProjects/Calculatrice/src/main/java/com/mycompany/calculatrice/fic.txt","w") as file:
    #    file.write(str(result))
    print(str(result))
except Exception as e:
    print("Erreur lors de l'evaluation de l'operation :", str(e))
