import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';

const useStyles = makeStyles(theme => ({
  container: {
    display: 'flex',
    flexWrap: 'nowrap',
  },
  textField: {
    marginLeft: theme.spacing(1),
    marginRight: theme.spacing(1),
    width: 200,
  },
}));

export default function DatePicker(props) {
  const classes = useStyles();

  return (
    <form className={classes.container} noValidate>
      <TextField
        id="date"
        name="departureDate"
        label="Departure date"
        type="date"
        format="dd/MM/yyyy"
        defaultValue={new Date()}
        className={classes.textField}
        InputLabelProps={{
          shrink: true,
        }}
        onChange={(e) => props.onChange(e.target.name, e.target.value)}
      />
    </form>
  );
}