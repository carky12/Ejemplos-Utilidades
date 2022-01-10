const User = require('../models/user');
const Coche = require('../models/coche');

module.exports = {

    index: async (req, res, next) => {
        const users = await User.find({});
        // throw new Error('dummy error');
        res.status(200).json(users);               
    },

    newUser: async (req, res, next) => {
        const newUser = new User(req.body);
        const user = await newUser.save();
        res.status(200).json(user);
    },

    getUser: async (req, res, next) => {
        const { userId } = req.params;
        const user = await User.findById(userId);
        res.status(200).json(user);
    },

    replaceUser: async (req, res, next) => {
        const { userId } = req.params;
        const newUser = req.body;
        const oldUser = await User.findByIdAndUpdate(userId, newUser);
        res.status(200).json({success: true});
    },

    updateUser: async (req, res, next) => {
        const { userId } = req.params;
        const newUser = req.body;
        const oldUser = await User.findByIdAndUpdate(userId, newUser);
        res.status(200).json({success: true});
    },

    deleteUser: async (req, res, next) => {
        const { userId } = req.params;        
        await User.findByIdAndRemove(userId);
        res.status(200).json({success: true});
    },
    
    getUserCars: async (req, res, next) => {
        const { userId } = req.params;
        const user = await User.findById(userId).populate('coches');
        res.status(200).json(user);       
    },

    newUserCar: async (req, res, next) => {
        const { userId } = req.params;
        const newCar = new Coche(req.body);
        const user = await User.findById(userId);
        newCar.vendedor = user;
        await newCar.save();
        user.coches.push(newCar);
        await user.save();
        res.status(201).json(newCar);
    }

}