var express = require('express');
var routesEngine = require('./jerryapp/routes/index.js'); // index.js actually
    // X, X.js, X.json and X.node see blog http://www.ruanyifeng.com/blog/2015/05/require.html
    
var app = express();
routesEngine(app);

app.listen(process.env.PORT || 3000, function () {
      // c:\\code\\git\\wechat\\app
  console.log('Listening on port 18080, process.cwd(): ' + process.cwd() );
});

   