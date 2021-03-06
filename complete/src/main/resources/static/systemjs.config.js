(function(global) {

//  var ngVer = '@2.0.0'; // lock in the angular package version; do not let it float to current!

  //map tells the System loader where to look for things
  var map = {
    'app':                        'app',
    '@angular':                   'https://unpkg.com/@angular', // sufficient if we didn't pin the version
    'rxjs':                       'https://unpkg.com/rxjs@5.0.0-beta.12',
    'ts':                         'https://unpkg.com/plugin-typescript@4.0.10/lib/plugin.js',
    'typescript':                 'https://unpkg.com/typescript@2.0.2/lib/typescript.js',
    'ng2-completer': 'node_modules/ng2-completer/bundles/ng2-completer.js',
    };

  //packages tells the System loader how to load when no filename and/or no extension
  var packages = {
    'app':                        { main: 'main.ts',  defaultExtension: 'ts' },
    'rxjs':                       { defaultExtension: 'js' }
  };

  var ngPackageNames = [
      'common',
      'compiler',
      'core',
      'forms',
      'http',
      'platform-browser',
      'platform-browser-dynamic',
      'router',
      'router-deprecated',
      'upgrade'
  ];

  // Add map entries for each angular package
  // only because we're pinning the version with `ngVer`.
  ngPackageNames.forEach(function(pkgName) {
    map['@angular/'+pkgName] = 'https://unpkg.com/@angular/' + pkgName;// + ngVer;
  });

  //Add package entries for angular packages
  ngPackageNames.forEach(function(pkgName) {

    // Bundled (~40 requests):
    packages['@angular/'+pkgName] = { main: '/bundles/' + pkgName + '.umd.js' };

    // Individual files (~300 requests):
    packages['@angular/'+pkgName] = { main: 'index.js', defaultExtension: 'js' };
  });

  var config = {
    // DEMO ONLY! REAL CODE SHOULD NOT TRANSPILE IN THE BROWSER
    transpiler: 'ts',
    typescriptOptions: {
      tsconfig: true
    },
    meta: {
      'typescript': {
        "exports": "ts"
      }
    },
    map: map,
    packages: packages
  };

  System.config(config);

})(this);

