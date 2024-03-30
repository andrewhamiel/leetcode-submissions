class FileSystem {
    class FileNode {
        String name = "";
        StringBuilder sb = new StringBuilder();
        boolean isDirectory = true;
        Map<String, FileNode> dirs = new HashMap<>();
        Map<String, FileNode> files = new HashMap<>();

        public FileNode(String name){
            this.name = name;
        }

        public List<String> sortDirectory() {
            if(isDirectory){
                List<String> result = new ArrayList<>();
                result.addAll(dirs.keySet());
                result.addAll(files.keySet());
                return result.stream().sorted().collect(Collectors.toList());
            } 
            return List.of(name);
        }

        public void addContentToFile(String newContent){
            sb.append(newContent);
        }

        public String getContent(){
            return sb.toString();
        }
    }

    FileNode root;

    public FileSystem() {
        root = new FileNode("");
    }
    
    public List<String> ls(String path) {
        String[] split = path.split("/");
        FileNode curr = root;
        if(split.length == 0) return curr.sortDirectory();
        
        for(int i = 0; i < split.length - 1; i++){
            if(split[i].isEmpty()) continue;
            if(!curr.dirs.containsKey(split[i])) return new ArrayList<>();
            curr = curr.dirs.get(split[i]);
        }
        if(curr.dirs.containsKey(split[split.length - 1])) curr = curr.dirs.get(split[split.length - 1]);
        else if(curr.files.containsKey(split[split.length - 1])) curr = curr.files.get(split[split.length - 1]);
        else return new ArrayList<>();
        
        return curr.sortDirectory();
    }
    
    public void mkdir(String path) {
        String[] split = path.split("/");
        FileNode curr = root;
        for(int i = 0; i < split.length; i++){
            if(split[i].isEmpty()) continue;
            curr.dirs.putIfAbsent(split[i], new FileNode(split[i]));
            curr = curr.dirs.get(split[i]);
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        String[] split = filePath.split("/");
        FileNode curr = root;
        for(int i = 0; i < split.length - 1; i++){
            if(split[i].isEmpty()) continue;
            if(!curr.dirs.containsKey(split[i])) return;
            curr = curr.dirs.get(split[i]);
        }
        if(!curr.files.containsKey(split[split.length - 1])){
            FileNode node = new FileNode(split[split.length - 1]);
            node.isDirectory = false;
            curr.files.put(split[split.length - 1], node);
        }
        curr = curr.files.get(split[split.length - 1]);
        curr.addContentToFile(content);
    }
    
    public String readContentFromFile(String filePath) {
        String[] split = filePath.split("/");
        FileNode curr = root;
        for(int i = 0; i < split.length - 1; i++){
            if(split[i].isEmpty()) continue;
            if(!curr.dirs.containsKey(split[i])) return "";
            curr = curr.dirs.get(split[i]);
        }
        if(!curr.files.containsKey(split[split.length - 1])) return "";
        curr = curr.files.get(split[split.length - 1]);
        return curr.getContent();
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */