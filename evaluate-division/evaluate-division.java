class Solution {
    HashMap<String, ArrayList<Pair<String, Double>>> map = new HashMap<String, ArrayList<Pair<String, Double>>>();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        var result = new double[queries.size()];
        String f, s;
        double value;
        for(int i=0; i<values.length; i++) {
            List<String> equation = equations.get(i);
            f=equation.get(0);
            s=equation.get(1);
            value = values[i];
            map.putIfAbsent(f, new ArrayList<>());
            map.putIfAbsent(s, new ArrayList<>());
            map.get(f).add(new Pair<>(s,value));
            map.get(s).add(new Pair<>(f, 1/value));
        }
        
        for(int i=0; i<queries.size(); i++) {
            List<String> equation = queries.get(i);
            f=equation.get(0);
            s=equation.get(1);
            if(!map.containsKey(f) || !map.containsKey(s)) {
                result[i]=-1;
                continue;
            }
            var visited = new HashSet<String>();
            result[i]=dfs(f, s, 1, visited);
        }
        return result;
    }
    
    double dfs(String source, String dest, double res, Set<String> visited) {
        visited.add(source);
        if(source.equals(dest)) return res;
        for(var adj: map.get(source)) {
            String curr = adj.getKey();
            double val = adj.getValue();
            if(!visited.contains(curr)) {
                double temp = dfs(curr, dest, res*val, visited);
                if(temp!=-1) return temp;
            }
        }
        return -1;
    }
}