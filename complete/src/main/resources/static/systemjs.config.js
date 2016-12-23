/**
 * System configuration for Angular 2 samples
 * Adjust as necessary for your application needs.
 */
//(function(global) {
//    // map tells the System loader where to look for things
//    var map = {
//        'app':                        'app', // 'dist',
//        '@angular':                   'node_modules/@angular',
//        'ng2-translate': 'npm:npm:ng2-translate/bundles/ng2-translate.umd.js',
//        'rxjs':                       'node_modules/rxjs'
//    };
//    // packages tells the System loader how to load when no filename and/or no extension
//    var packages = {
//        'app':                        { main: 'main.ts',  defaultExtension: 'ts' },
//        "ng2-translate": {
//            main: "bundles/index.js",
//            defaultExtension: "js"
//        },
//        'rxjs':                       { defaultExtension: 'js' }
//    };
//    var ngPackageNames = [
//        'common',
//        'compiler',
//        'core',
//        'forms',
//        'http',
//        'platform-browser',
//        'platform-browser-dynamic',
//        'router',
//        'router-deprecated',
//        'upgrade'
//    ];
//
//
//    // Individual files (~300 requests):
//    function packIndex(pkgName) {
//        packages['@angular/'+pkgName] = { main: 'index.js', defaultExtension: 'js' };
//    }
//    // Bundled (~40 requests):
//    function packUmd(pkgName) {
//        packages['@angular/'+pkgName] = { main: '/bundles/' + pkgName + '.umd.js', defaultExtension: 'js' };
//    }
//    // Most environments should use UMD; some (Karma) need the individual index files
//    var setPackageConfig = System.packageWithIndex ? packIndex : packUmd;
//    // Add package entries for angular packages
//    ngPackageNames.forEach(packUmd);//setPackageConfig);
//
//    var config = {
////        transpiler: 'ts',
//        typescriptOptions: {
//          tsconfig: true
//        },
//        meta: {
//          'typescript': {
//            "exports": "ts"
//          }
//        },
//        map: map,
//        packages: packages
//    };
//    System.config(config);
//})(this);




(function(global) {

//  var ngVer = '@2.0.0'; // lock in the angular package version; do not let it float to current!

  //map tells the System loader where to look for things
  var map = {
    'app':                        'app',
    '@angular':                   'https://unpkg.com/@angular', // sufficient if we didn't pin the version
    'rxjs':                       'https://unpkg.com/rxjs@5.0.0-beta.12',
    'ts':                         'https://unpkg.com/plugin-typescript@4.0.10/lib/plugin.js',
    'typescript':                 'https://unpkg.com/typescript@2.0.2/lib/typescript.js'
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


///*
//Copyright 2016 Google Inc. All Rights Reserved.
//Use of this source code is governed by an MIT-style license that
//can be found in the LICENSE file at http://angular.io/license
//*/
