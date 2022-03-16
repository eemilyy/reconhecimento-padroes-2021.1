from sklearn import datasets
from sklearn.neighbors import KNeighborsClassifier
from sklearn.datasets import load_wine
from sklearn.model_selection import train_test_split
from sklearn.metrics import confusion_matrix
from sklearn.metrics import precision_score
from sklearn.metrics import recall_score
from sklearn.metrics import f1_score

def matriz_confusao(verdadeiro_y,estimado_y):
    i = 0
    matriz = [[0,0,0],
                        [0,0,0],
                        [0,0,0]]
    while(i < len(verdadeiro_y)):

        if (verdadeiro_y[i]) == 0:
            if(estimado_y[i]) == 0:
                matriz[0][0] += 1
            elif(estimado_y[i]) == 1:
                matriz[0][1] += 1
            else:
                matriz[0][2] +=1

        elif (verdadeiro_y[i]) == 1:
            if(estimado_y[i]) == 0:
                matriz[1][0] += 1
            elif(estimado_y[i]) == 1:
                matriz[1][1] += 1
            else:
                matriz[1][2] +=1   

        else:
            if(estimado_y[i]) == 0:
                matriz[2][0] += 1
            elif(estimado_y[i]) == 1:
                matriz[2][1] += 1
            else:
                matriz[2][2] +=1
        i= i+1
    return matriz

def calcular_taxa_de_acerto(c_matriz):
    #A taxa de acerto do classificador é a (soma da diagonal principal)/(soma total da matriz)

    #somando diagonal principal
    #soma_diagonal = c_matriz[0][0] + c_matriz[1][1] + c_matriz[2][2]
    soma_total = 0
    #somando total matriz
    for i in range(3):
        for j in range(3):
            soma_total += c_matriz[i][j]
    
    print(soma_total)
    #print(soma_diagonal)

    taxa_acerto = (c_matriz[0][0] + c_matriz[1][1] + c_matriz[2][2]) / soma_total
    #print(taxa_acerto)
    print("A taxa de acerto é {0:.2f}".format(taxa_acerto))

def calcular_taxa_de_precisao(c_matriz):
    # presisao = taxa_de_acerto da classe / soma de toda classe

    #taxa de preciso classe 0
    classe_0 = c_matriz[0][0] / (c_matriz[0][0] + c_matriz[1][0] + c_matriz[2][0])
    #taxa de precisao classe 1
    classe_1 = c_matriz[1][1] / (c_matriz[0][1] + c_matriz[1][1] + c_matriz[2][1])
    #taxa de precisao classe 2
    classe_2 = c_matriz[2][2] / (c_matriz[0][2] + c_matriz[1][2] + c_matriz[2][2])

    #print("Taxa de Precisão:\nClasse 0 = {0}\nClasse 1 = {1}\nClasse 2 = {2}".format(classe_0, classe_1, classe_2))
    return classe_0, classe_1, classe_2

def calcular_taxa_de_recall(c_matriz):
    # presisao = taxa_de_acerto da classe / soma de toda classe

    #taxa de preciso classe 0
    classe_0 = c_matriz[0][0] / (c_matriz[0][0] + c_matriz[0][1] + c_matriz[0][2])
    #taxa de precisao classe 1
    classe_1 = c_matriz[1][1] / (c_matriz[1][0] + c_matriz[1][1] + c_matriz[1][2])
    #taxa de precisao classe 2
    classe_2 = c_matriz[2][2] / (c_matriz[2][0] + c_matriz[2][1] + c_matriz[2][2])

    print("Taxa de Recall:\nClasse 0 = {0}\nClasse 1 = {1}\nClasse 2 = {2}".format(classe_0, classe_1, classe_2))
    return classe_0, classe_1, classe_2

def medida_F(pre_classe1, pre_classe2, pre_classe3, rec_classe1, rec_classe2, rec_classe3):
    f1 = 2 * (pre_classe1 * rec_classe1) / (pre_classe1 + rec_classe1)
    f2 = 2 * (pre_classe2 * rec_classe2) / (pre_classe2 + rec_classe2)
    f3 = 2 * (pre_classe3 * rec_classe3) / (pre_classe3 + rec_classe3)

    return f1, f2, f3


x,y = load_wine(return_X_y = True)
treino_x, teste_x, treino_y, teste_y = train_test_split(x,y,test_size=0.30) #test_size proporção 

knn = KNeighborsClassifier(n_neighbors=1, weights= "distance",metric="euclidean")
knn.fit(treino_x,treino_y)

estimado_y = knn.predict(teste_x)
verdadeiro_y = teste_y
#print(confusion_matrix(verdadeiro_y,estimado_y)) #confusion_matrix(verdadeiro_y, estimado_y) API
c_matriz = matriz_confusao(verdadeiro_y,estimado_y)
# print(c_matriz[0])
# print(c_matriz[1])
# print(c_matriz[2])

calcular_taxa_de_acerto(c_matriz)
pre_classe1, pre_classe2, pre_classe3 = calcular_taxa_de_precisao(c_matriz)
print("Precisão:\nClasse 0 = {0}\nClasse 1 = {1}\nClasse 2 = {2}".format(pre_classe1, pre_classe2, pre_classe3))
print(precision_score(verdadeiro_y,estimado_y, average=None))
rec_classe1, rec_classe2, rec_classe3 = calcular_taxa_de_recall(c_matriz)
print(recall_score(verdadeiro_y, estimado_y, average=None))
f1, f2, f3 = medida_F(pre_classe1, pre_classe2, pre_classe3, rec_classe1, rec_classe2, rec_classe3)
print("Medida F:\nClasse 0 = {0}\nClasse 1 = {1}\nClasse 2 = {2}".format(f1, f2, f3))
print(f1_score(verdadeiro_y, estimado_y, average=None))