from sklearn import datasets
from sklearn.neighbors import KNeighborsClassifier
from sklearn.datasets import load_wine
from sklearn.model_selection import train_test_split
from sklearn.metrics import accuracy_score
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

def taxa_acerto(c_matriz):
    soma_total = 0
    for i in range(3):
        for j in range(3):
            soma_total += c_matriz[i][j]

    taxa_acerto = (c_matriz[0][0] + c_matriz[1][1] + c_matriz[2][2]) / soma_total
    return taxa_acerto

def taxa_precisao(c_matriz):

    classe_0 = c_matriz[0][0] / (c_matriz[0][0] + c_matriz[1][0] + c_matriz[2][0])
    classe_1 = c_matriz[1][1] / (c_matriz[0][1] + c_matriz[1][1] + c_matriz[2][1])
    classe_2 = c_matriz[2][2] / (c_matriz[0][2] + c_matriz[1][2] + c_matriz[2][2])

    return classe_0, classe_1, classe_2

def taxa_recall(c_matriz):

    classe_0 = c_matriz[0][0] / (c_matriz[0][0] + c_matriz[0][1] + c_matriz[0][2])
    classe_1 = c_matriz[1][1] / (c_matriz[1][0] + c_matriz[1][1] + c_matriz[1][2])
    classe_2 = c_matriz[2][2] / (c_matriz[2][0] + c_matriz[2][1] + c_matriz[2][2])

    return classe_0, classe_1, classe_2

def medida_F(pre_classe1, pre_classe2, pre_classe3, rec_classe1, rec_classe2, rec_classe3):
    f1 = 2 * (pre_classe1 * rec_classe1) / (pre_classe1 + rec_classe1)
    f2 = 2 * (pre_classe2 * rec_classe2) / (pre_classe2 + rec_classe2)
    f3 = 2 * (pre_classe3 * rec_classe3) / (pre_classe3 + rec_classe3)

    return f1, f2, f3

def calcula_fp(c_matriz):

    classe_0 = (c_matriz[1][0] + c_matriz[2][0]) / ((c_matriz[1][0] + c_matriz[2][0]) + (c_matriz[1][1] + c_matriz[1][2] + c_matriz[2][1] + c_matriz[2][2]))
    classe_1 = (c_matriz[0][1] + c_matriz[2][1]) / ((c_matriz[0][1] + c_matriz[2][1]) + (c_matriz[0][0] + c_matriz[0][2] + c_matriz[2][0] + c_matriz[2][2]))
    classe_2 = (c_matriz[0][2] + c_matriz[1][2]) / ((c_matriz[0][2] + c_matriz[1][2]) + (c_matriz[0][0] + c_matriz[0][1] + c_matriz[1][0] + c_matriz[1][1]))

    return classe_0, classe_1, classe_2


x,y = load_wine(return_X_y = True)
treino_x, teste_x, treino_y, teste_y = train_test_split(x,y,test_size=0.30) 

knn = KNeighborsClassifier(n_neighbors=1, weights= "distance",metric="euclidean")
knn.fit(treino_x,treino_y)
estimado_y = knn.predict(teste_x)
verdadeiro_y = teste_y


c_matriz = matriz_confusao(verdadeiro_y,estimado_y)
print(c_matriz[0])
print(c_matriz[1])
print(c_matriz[2])

rec_classe1, rec_classe2, rec_classe3 = taxa_recall(c_matriz)
print("Recall: [ {0}  {1}  {2} ]".format(rec_classe1, rec_classe2, rec_classe3))
acerto = taxa_acerto(c_matriz)
print("Taxa de acerto: " + str(acerto))
pre_classe1, pre_classe2, pre_classe3 = taxa_precisao(c_matriz)
print("Precisão: [ {0}  {1}  {2} ]".format(pre_classe1, pre_classe2, pre_classe3))
f1, f2, f3 = medida_F(pre_classe1, pre_classe2, pre_classe3, rec_classe1, rec_classe2, rec_classe3)
print("Medida F: [ {0}  {1}  {2} ]".format(f1, f2, f3))
fp_c1, fp_c2, fp_c3 = calcula_fp(c_matriz)
print("FP: [ {0}  {1}  {2} ]".format(fp_c1, fp_c2, fp_c3))

print("-"*50)

print("Matriz calculada por API = \n" + str(confusion_matrix(verdadeiro_y,estimado_y)))
print("Recall dado pela API = " + str(recall_score(verdadeiro_y, estimado_y, average=None)))
print("Taxa de acerto dado pela API = " + str(accuracy_score(verdadeiro_y, estimado_y)))
print("Precisão dado pela API = " + str(precision_score(verdadeiro_y,estimado_y, average=None)))
print("Medida-F dado pela API = " + str(f1_score(verdadeiro_y, estimado_y, average=None)))