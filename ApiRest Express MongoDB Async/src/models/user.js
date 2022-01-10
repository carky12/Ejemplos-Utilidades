const mongoose = require('mongoose');
const schema = mongoose.Schema;

const userSchema = new schema({
    nombre: String,
    apellidos: String,
    email: String,
    coches: [{
        type: schema.Types.ObjectId,
        ref: 'coche'
    }]
});

module.exports = mongoose.model('user', userSchema);