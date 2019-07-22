import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import Input from "@material-ui/core/Input";
import OutlinedInput from "@material-ui/core/OutlinedInput";
import FilledInput from "@material-ui/core/FilledInput";
import InputLabel from "@material-ui/core/InputLabel";
import MenuItem from "@material-ui/core/MenuItem";
import FormHelperText from "@material-ui/core/FormHelperText";
import FormControl from "@material-ui/core/FormControl";
import Select from "@material-ui/core/Select";

const useStyles = makeStyles(theme => ({
  root: {
    display: "inline-flex",
    flexWrap: "nowrap"
  },
  formControl: {
    margin: theme.spacing(1),
    minWidth: 120
  },
  selectEmpty: {
    marginTop: theme.spacing(2)
  }
}));

export default function SimpleSelect(props) {
  const classes = useStyles();
  const [values, setValues] = React.useState({
    id: "",
    name: ""
  });

  function handleChange(event) {
    setValues(oldValues => ({
      ...oldValues,
      [event.target.name]: event.target.value
    }));
    props.onChange(props.fieldName, event.target.value);
  }
  const items = props.airports.map(airport => (
    <MenuItem value={airport.id}>{airport.name}</MenuItem>
  ));
  return (
    <form className={classes.root} autoComplete="off">
      <FormControl className={classes.formControl}>
        <InputLabel htmlFor={props.name}>{props.name}</InputLabel>
        <Select
          value={values.name}
          onChange={handleChange}
          inputProps={{
            name: 'name',
            id: 'id'
          }}
        >
         {items}
        </Select>
      </FormControl>
    </form>
  );
}
