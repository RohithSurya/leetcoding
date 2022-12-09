class ValidWordAbbr {
    
    Map<String, Set<String>> map = new HashMap<>();

    public ValidWordAbbr(String[] dictionary) { 
        String abbr=null;
        for(String word: dictionary) {
            abbr = convertToAbbr(word);
            if(!map.containsKey(abbr))  map.put(abbr, new HashSet<String>());
            map.get(abbr).add(word);
        }

    }
    
    String convertToAbbr(String word) {
        int n=word.length();
        if(n<=2) return word;
        else
        return String.format("%c%d%c", word.charAt(0), n-2, word.charAt(n-1));
    }
    
    public boolean isUnique(String word) {
        String abbr = convertToAbbr(word);
        if(!map.containsKey(abbr)) return true;
        Set<String> set = map.get(abbr);
        return set.contains(word) && set.size()==1;
        
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */