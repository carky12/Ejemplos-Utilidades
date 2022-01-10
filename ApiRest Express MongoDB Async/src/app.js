const bodyParser = require('body-parser');
const morgan = require('morgan');
const express =  require('express');
const mongoose = require('mongoose');
const { application } = require('express');

const app = express();

const usersRoutes = require('./routes/users');

//conexión a db
mongoose.connect('mongodb://localhost/rest-api-node')
.then(db => console.log('conected'))
.catch(err => console.log(err));

//configuración
app.set('port', process.env.PORT || 3000);

app.use(morgan('dev'));
app.use(express.json());
app.use(express.urlencoded({
    extended: true
  }));

//routes
app.use('/users', usersRoutes);

//arrancar el servidor
app.listen(app.get('port'), () => {
    console.log('server on port ', app.get('port'))
});