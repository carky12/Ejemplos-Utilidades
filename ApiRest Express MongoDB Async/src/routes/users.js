const router = require('express-promise-router')();
// const express = require('express');
// const router = express.Router();

const {
    index,
    newUser,
    getUser,
    replaceUser,
    deleteUser,
    getUserCars,
    newUserCar
} = require('../controllers/user')

router.get('/', index)
router.get('/:userId', getUser)
router.post('/', newUser)
router.put('/:userId', replaceUser)
router.delete('/:userId', deleteUser)

router.get('/:userId/coches', getUserCars)
router.post('/:userId/coches', newUserCar)

module.exports= router;