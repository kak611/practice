import java.util.*;

/*
 1. Given a Array of Strings of directory names, print out the filenames in each directory.
 func: printFilesPerDirectory(dirnames)

 2. Given an array of directory, get the files with latest version
 func: getLatestVersionFiles(dirnames)

  Following functions are available:
    public String[] getFiles(String dirName) {...}
    public String getBaseFileName(String filename) {...}
    public int getVersion(String filename) {...}
*/

class DirectoryTraversal {
  // map of { directory name => Set of files in directory }
  private Map<String, Set<String>> directory_map;
  // map of { file basename => File object }
  private Map<String, File> files_map;

  // constructor
  public DirectoryTraversal() {
    directory_map = new HashMap<>();    
    files_map = new HashMap<>();
  }


  // getLatestVersionFiles returns a map of {directoryname => list of files with latest version in curr directory}
  public Map<String, List<String>> getLatestVersionFiles(String[] dirnames)  {
    // dir : list of files with latest version
    Map<String, List<String>> result = new HashMap();
    for (dirname : dirnames) {
      List<String> filenames = getFiles(dirname);

      for (String filename : filenames) {
        // get file object
        String basename = getBaseFileName(filename);
        File obj = files_map.get(basename);

        // get latest version of file from object
        String latestVersionFile = obj.getLatestVersionFile();
        
        // if file is not visited, add it to the result
        if (!set.contains(basename)) {
          set.add(basename);
          result.putIfAbsent(dir, new ArrayList<String>());
          result.get(dir).add(latestVersionFile)
        }
      }
    }

    return result;
  }

  // print files in each directory
  // assuming we want to print all versions of file
  public void printFilesPerDirectory(String[] dirnames) {
    // create data structure
    updateDirectories(dirnames);

    for (Map.Entry<String, Set<String>> entry : directory_map.entrySet()) {
      String dirname = (String) entry.getKey();
      List<String> files = entry.getValue();
      System.out.println(dirname + ": " + files);
    }
  }

  // create data structure
  private void updateDirectories(String[] dirnames) {
    for (String dirname : dirnames) {
      List<String> filenames = getFiles(dirname);
      for (String filename : filenames) {
        // add files to directory_map        
        directory_map.putIfAbsent(dirname, new HashSet<String>());
        directory_map.get(dirname).add(filename);

        // add file to files_map
        String basename = getBaseFileName(filename);
        File file = files_map.get(basename);
        if (file == null) {
          file = new File(basename);          
          files_map.put(basename, file);
        }
        file.addVersion(version, dirname);
      }
    }
  }


  /* 
     File
     basename    : base name
     version_map : map of { version => set of directories }
  */
  class File {
    String basename;    
    TreeMap<Integer, Set<String>> version_map;    

    public File(String basename) {
      this.basename = basename;      
      // treemap of version: set of directories
      // assumption : same version of file might be present in different directories
      version_map = new TreeMap<>(Collections.reverseOrder());
    }

    public void addVersion(int version, String directory) {      
      version_map.put(version, new HashSet<String>());
      version_map.get(version).add(directory);
    }


    // return the first entry key in treemap
    public String getLatestVersionFile() {
      int version = 0;
      for (TreeMap.Entry<Integer, Set<String>> entry : version_map.entrySet()) {
        version = (int) entry.getKey();        
        break;
      }

      return getFilename(basename, version);
    }

  }

}