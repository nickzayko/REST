package WebServiceREST;

import dao.CarDAO;
import dto.CarDTO;
import entity.Car;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.List;

@Path("/cars")
public class CarWebServiceREST {

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Car> getCars() {
        return CarDAO.getAllCars();
    }

    @GET
    @Path("/{carId}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Car getCar(@PathParam("carId") String carId) {
        return CarDAO.getCar(carId);
    }

    @DELETE
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Car deleteCar(@PathParam("id") String id){
       return CarDAO.deleteCar(id);
    }

//    ------Можно отправлять запрос отдельными параметрами, аналог простой формы-------
//    @POST
//    public Car addCar(@QueryParam("id") Integer id,
//                      @QueryParam("model") String model,
//                      @QueryParam("color") String color,
//                      @QueryParam("price") Integer price){
//        Car car = new Car();
//        car.setId(id);
//        car.setModel(model);
//        car.setColor(color);
//        car.setPrice(price);
//        return CarDAO.addCar(car);
//    }
//---------------------------------------------------------------------------------------

    @POST
    public Car addCar(Car car){
        return CarDAO.addCar(car);
    }

    @PUT
    @Path("/{id}")
    public Car updateCar(@PathParam("id")Integer id,
                         CarDTO newCar){
        return CarDAO.updateCar(id, newCar);
    }

}
