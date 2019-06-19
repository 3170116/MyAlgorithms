#This function takes as input a graph and two vertexes of it
#and returns the number of different paths from s to t
#with distance as K

#sub_problem: opt(i,j,k) = number of diferrent paths from i to j with length = k
#V:list of vertexes
#E:list of edges
def getDifferentPaths(V,E,s,t,K):
 #opt(i,j,1) = 0 if there is not the (i,j) edge else 1
 for i in range(len(V)):
   for j in range(len(V)):
     opt(i,j,1) = 0
     if tuple(V(i),V(j)) in E:
       opt(i,j,1) = 1
 
  for k in range(2,K+1):
    for i in range(len(V)):
      for j in range(len(V)):
        opt(i,j,k) = 0
        for v in V:
          if tuple(v,V(j)) in E:
            opt(i,j,k) += opt(i,v,k-1)
          
  for i in range(len(V)):
    for j in range(len(V)):
      if tuple(V(i),V(j)) == tuple(s,t):
        return opt(i,j,k)
