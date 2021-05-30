import React, { useState, useEffect } from "react";

const initialLocationState = {
  latitude: null,
  longitude: null,
  speed: null,
};

const App = () => {
  const [count, setCount] = useState(0);

  const [isOn, setIsOn] = useState(false);

  const [mousePosition, setMousePosition] = useState({
    x: null,
    y: null,
  });

  const [status, setStatus] = useState(navigator.onLine);

  const [{ latitude, longitude, speed }, setLocation] =
    useState(initialLocationState);

  let mounted = true;

  useEffect(() => {
    document.title = `You have clicked ${count} times`;
    window.addEventListener("mousemove", handleMouseMove);
    window.addEventListener("online", handleOnline);
    window.addEventListener("offline", handleOffline);
    navigator.geolocation.getCurrentPosition(handleGeolocation);
    const watchId = navigator.geolocation.watchPosition(handleGeolocation);

    return () => {
      window.removeEventListener("mousemove", handleMouseMove);
      window.removeEventListener("online", handleOnline);
      window.removeEventListener("offline", handleOffline);
      mounted = false;
      navigator.geolocation.clearWatch(watchId);
    };
  }, [count]);

  const handleGeolocation = (event) => {
    console.log("The event is : ", event);

    if (mounted) {
      setLocation({
        latitude: event.coords.latitude,
        longitude: event.coords.longitude,
        speed: event.coords.speed,
      });
    }
  };

  const handleOnline = (event) => {
    setStatus(true);
  };

  const handleOffline = (event) => {
    setStatus(false);
  };

  const handleMouseMove = (event) => {
    setMousePosition({
      x: event.pageX,
      y: event.pageY,
    });
  };

  const incrementCount = () => {
    setCount((prevCount) => prevCount + 1);
  };

  const toggleLight = () => {
    setIsOn((prevIsOn) => !prevIsOn);
  };

  return (
    <>
      <h2>Counter</h2>
      <button onClick={incrementCount}>I was clicked {count}</button>

      <h2>Toggle light</h2>
      <img
        style={{
          height: "50px",
          width: "50px",
          background: isOn ? "yellow" : "grey",
        }}
        onClick={toggleLight}
      ></img>

      <h2>Mouse position</h2>
      <p>X position : {mousePosition.x}</p>
      <p>Y position : {mousePosition.y}</p>

      <h2>Network status</h2>
      <p>You are {status ? "online" : "offline"}</p>

      <h2>Geolocation</h2>
      <p>Latitude : {latitude}</p>
      <p>Longitude : {longitude}</p>
      <p>Speed : {speed ? speed : "0"}</p>
    </>
  );
};

export default App;
