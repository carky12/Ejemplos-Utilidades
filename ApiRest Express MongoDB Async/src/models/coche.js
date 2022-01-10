const mongoose = require('mongoose');
const schema = mongoose.Schema;

const cocheSchema = new schema({
    marca: String,
    modelo: String,
    axo: Number,
    usuario: {
        type: schema.Types.ObjectId,
        ref: 'user'
    }
});

module.exports = mongoose.model('coche', cocheSchema);